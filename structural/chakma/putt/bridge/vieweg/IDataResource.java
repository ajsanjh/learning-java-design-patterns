package chakma.putt.bridge.vieweg;

public interface IDataResource {
	String info();
	String snippit();
}


class AlbumResource implements IDataResource {
	Album data = new Album();
	AlbumResource(Album data){
		this.data = data;
	}
	@Override
	public String info() {
		String s = 
				this.data.getTitle() + "\n" +
				this.data.getImageUrl() + "\n" +
				this.data.getDetailsPage();
		return s;
	}

	@Override
	public String snippit() {
		String s = 
				this.data.getArtists() + "\n" +
				this.data.getPreview() + "\n";
		return s;
	}
	
}


class BookResource implements IDataResource {
	Book data = new Book();
	BookResource(Book data) {
		this.data = data;
	}
	@Override
	public String info() {
		String s = 
		this.data.getTitle() + "\n" +
		this.data.getAuther() + "\n" +
		this.data.getImageUrl();
		return s;
	}

	@Override
	public String snippit() {
		String s = 
				this.data.getPrelogue() + "\n" +
				this.data.getDetailsPage();
		return s;
	}
	
}
