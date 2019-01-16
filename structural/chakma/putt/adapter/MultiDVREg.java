package chakma.putt.adapter;

public class MultiDVREg {

	public static void main(String[] args) {
		MultiDVREg m = new MultiDVREg();
		
		DVR sony = m.new SonyDvrAdapter();
		DVR samsung = m.new SamsungDvrAdapter(); // can be easily switched with DI
		
		// we have simple play for both 
		sony.startPlayback(3);
		samsung.startPlayback(0);
		
		// smart home
		sony.launchSmartHome();  // RE!! 
		samsung.launchSmartHome();
		
		
	}
	
	
	
	
	
	private interface DVR {
		void startPlayback(int sec);
		void launchSmartHome();
	}
	
	/**
	 * adapter for sony and samsung dvr
	 * @author AJ
	 *
	 */
	
	private class SonyDvrAdapter implements DVR {
		SonyDVR dvr;
		public SonyDvrAdapter() {
			this.dvr = new SonyDVR();
		}
		@Override
		public void startPlayback(int sec) {
			dvr.startPlayBack(sec);
		}
		@Override
		public void launchSmartHome() {
			throw new RuntimeException("functionality not supported");
		}
	}
	
	
	private class SamsungDvrAdapter implements DVR{
		SamsungHDSmartDVR dvr;
		public SamsungDvrAdapter() {
			this.dvr = new SamsungHDSmartDVR();
		}
		
		@Override
		public void startPlayback(int sec) {
			this.dvr.playBackState(PlayState.START);
		}
		
		@Override
		public void launchSmartHome() {
			this.dvr.smartHomeLaunch();
		}
	}
	
	
	
	
	/*
	 * our dvr libraries with different impls and no common contract
	 */
	
	/** first DVR */
	private class SonyDVR {
		void startPlayBack(int startSecond) {
			System.out.println("sony dvr play at: " + startSecond + " sec.");
		}
		
		void stopPlayBack() {
			System.out.println("sony dvr playback stop");
		}
		
		void startRecording(boolean saveInternally) {
			System.out.println("recording... saving internally: " + saveInternally);
		}
	}
	
	
	
	/** samsung DVR */
	private class SamsungHDSmartDVR {
		void playBackState(PlayState ps) {
			switch (ps) {
			case START:
				System.out.println("samsun playback started");
				break;
			case STOP:
				System.out.println("samsun playback stoped");
				break;
			}
		}
		
		void smartHomeLaunch() {
			System.out.println("samsung smart home launched");
		}
	}
	
	
	
}
enum PlayState { START, STOP };






