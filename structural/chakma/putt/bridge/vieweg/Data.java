package chakma.putt.bridge.vieweg;


public interface Data {

}

class Album implements Data {
	public String getTitle() {
		return "incomplete";
	}
	public String getArtists() {
		return "bsb";
	}
	public String getPreview() {
		return "preview for incomplete";
	}
	public String getImageUrl() {
		return "http://imageurltobsb.com/images/image2343";
	}
	public String getDetailsPage() {
		return "http://urltohomepage/src/artists/bsb";
	}
}

class Book implements Data {
	public String getTitle() {
		return "Who Moved my cheeze";
	}
	public String getAuther() {
		return "idk";
	}
	public String getPrelogue() {
		return "who moved my cheese snippit";
	}
	public String getImageUrl() {
		return "http://imageurltowmmc.com/images/image2343";
	}
	public String getDetailsPage() {
		return "http://urltohomepage/src/artists/wmmc";
	}
}
