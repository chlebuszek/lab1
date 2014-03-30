package mainboard;

import gral2demo.SataHddDrive;
import gral2demo.*;

 class SataPort {

	 private String description;
		private Mainboard mainboard;
		private boolean avaible = true;
		private SataHddDrive drive;
		private CdRom cddrive;
		public SataPort(Mainboard mainboard) {
			
			this.mainboard = mainboard;
		}

		public void installDevice(SataHddDrive drive)
		{
			drive.setMainboard(mainboard);
			description=drive.getDescription();
			this.drive=drive;
			this.avaible=false;
		}
		
		public void installDevice(CdRom cddrive)
		{
			cddrive.setMainboard(mainboard);
			description=cddrive.getDescription();
			this.cddrive=cddrive;
			this.avaible=false;
		}


		public void unInstallDevice()
		{
			drive.setMainboard(null);
			description=null;
			this.avaible=true;
		}

		public String getDescription() {
			return description;
		}

		public boolean isAvaible() {
			return avaible;
		}

}
		
		
		
