package gral2demo;

import mainboard.Mainboard;

public class Main {

	public static void main(String[] args) {
		
		Mainboard gigabyte = new Mainboard(1,3);
		AgpGraphicCard nvidia = new AgpGraphicCard();
		nvidia.setDescription("Karta nvidia\n");
		
		HddDrive samsung = new HddDrive();
		samsung.setDescription("Dysk twardy Samsung");
		SataHddDrive wd = new SataHddDrive();
		wd.setDescription("Dysk twardy WD SATA");
		
		CdRom asus = new CdRom();
		asus.setDescription("CDROM ASUS");
		
		
		LanCard lankarta = new LanCard();
		lankarta.setDescription("KARTA LAN")
		
		gigabyte.installAgpGraphicCard(nvidia);
		gigabyte.installPciSlot(lankarta);
		gigabyte.installIdeDevice(samsung, 0);
		gigabyte.installSataDevice(wd, 1);
		gigabyte.installSataDevice(asus, 2);
		
		System.out.print(gigabyte.getFullDescription());
		gigabyte.installIdeDevice(samsung, 0);
		gigabyte.installSataDevice(wd, 1);
		gigabyte.installSataDevice(asus, 2);
		
	}

}
