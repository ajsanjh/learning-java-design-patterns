package chakma.putt.bridge;

public class BridgePatternEg {
	public static void main(String[] args) {
		BridgePatternEg b = new BridgePatternEg();

		System.out.println(b.new LongFormView(b.new ArtistResource(b.new Artist())).show());
		
	}
	
	
	
	/** left side of the bridle : the abstraction */
	private abstract class View {
		IResource resource;
		protected View(IResource resource) {
			this.resource = resource;
		}
		public abstract String show();
	}
	
	
	private class LongFormView extends View {
		public LongFormView(IResource resource) {
			super(resource);
		}
		@Override
		public String show() {
			String ourHtml = 
					super.resource.snipit() +
					super.resource.title() +
					super.resource.image() +
					super.resource.url();
			
			return ourHtml;
		}
	}
	
	
	
	/** right side of the bridge .. the concretion */
	private interface IResource {
		String snipit();
		String title();
		String image(); // image for the url
		String url();  // url location for when we click this resource
	}

	class ArtistResource implements IResource {
		Artist artist;
		public ArtistResource(Artist artist) {
			this.artist = artist;
		}
		@Override
		public String snipit() {
			return this.artist.bio();
		}
		@Override
		public String title() {
			return null;
		}
		@Override
		public String image() {
			return null;
		}
		@Override
		public String url() {
			return null;
		}
	}
	
	
	class Artist {
		public String bio() {
			return "name and history of the artist";
		}
	}
	
	
	class BookResource implements IResource{
		Book book;
		public BookResource(Book book) {
			this.book = book;
		}
		@Override
		public String snipit() {
			return this.book.prelouge();
		}
		@Override
		public String title() {
			return null;
		}
		@Override
		public String image() {
			return null;
		}
		@Override
		public String url() {
			return null;
		}
	}

	class Book {
		public String prelouge() {
			return "prelouge of the book";
		}
	}
	
}










/* EOF *********/