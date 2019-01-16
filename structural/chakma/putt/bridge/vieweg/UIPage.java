package chakma.putt.bridge.vieweg;

public class UIPage {
	public static void main(String[] args) {
		String viewType = "longAlbum";
		
		Album a1 = new Album();
		Album a2 = new Album();
		IDataResource a1Resource = new AlbumResource(a1);
		
		View view = null;
				switch (viewType) {
				case "longAlbum":
					view = new LongFormView(a1Resource);
					break;
				case "longBook":
					break;
		
				default:
					break;
				}

		view.show();
	}
}

abstract class View {
	IDataResource resource;
	protected View(IDataResource resource) {
		this.resource = resource;
	}
	abstract void show();
}

class LongFormView extends View {
	protected LongFormView(IDataResource resource) {
		super(resource);
	}

	@Override
	void show() {
		String s = 
				super.resource.info() + "\n" +
						super.resource.snippit();
		System.out.println(s);
	}
}

class ShortFormView extends View {
	protected ShortFormView(IDataResource resource) {
		super(resource);
	}
	@Override
	void show() {
		String s = 
				super.resource.info();
		System.out.println(s);
	}
}


//class LongFormViewForAlbum implements View {
//	private Album data;
//	public LongFormViewForAlbum(Album data) {
//		this.data = data;
//	}
//	@Override
//	public void show() {
//		System.out.println(
//				this.data.getTitle() + "\n" +
//				this.data.getArtists() + "\n" +
//				this.data.getImageUrl() + "\n" +
//				this.data.getPreview() + "\n" +
//				this.data.getDetailsPage() + "\n"
//				);
//	}
//}
//
//class LongFormViewForBook implements View {
//	private Book data;
//	public LongFormViewForBook(Book data) {
//		this.data = data;
//	}
//	@Override
//	public void show() {
//		System.out.println(
//				this.data.getTitle() + "\n" +
//				this.data.getAuther() + "\n" +
//				this.data.getImageUrl() + "\n" +
//				this.data.getSnippit() + "\n" +
//				this.data.getDetailsPage() + "\n"
//				);
//	}
//}
//
//
//class ShortFormViewForAlbum implements View {
//	private Album data;
//	public ShortFormViewForAlbum(Album data) {
//		this.data = data;
//	}
//	@Override
//	public void show() {
//		System.out.println(
//				this.data.getTitle() + "\n" +
//				this.data.getImageUrl() + "\n" +
//				this.data.getDetailsPage() + "\n"
//				);
//	}
//}
//
//class ShortFormViewForBook implements View {
//	private Book data;
//	public ShortFormViewForBook(Book data) {
//		this.data = data;
//	}
//	@Override
//	public void show() {
//		System.out.println(
//				this.data.getTitle() + "\n" +
//				this.data.getImageUrl() + "\n" +
//				this.data.getDetailsPage() + "\n"
//				);
//	}
//}
























/* ** EOF *** ***** **** */