package mainboard;

import gral2demo.AgpGraphicCard;
import gral2demo.HddDrive;
import gral2demo.SataHddDrive;
import gral2demo.*;

public class Mainboard {

	private IdePort[] idePorts;
	private AgpSlot agpSlot;
	private SataPort[] sataPorts;
	private PciSlot pciSlot;
	private PciExpressSlot pciExpressSlot;
	
	public Mainboard(int idePorts, int sataPorts)
	{
		this.idePorts=new IdePort[idePorts];
		for(int i=0;i<idePorts;i++)
			this.idePorts[i]=new IdePort(this);
		this.agpSlot=new AgpSlot(this);
		
		this.sataPorts=new SataPort[sataPorts];
		for(int j=0;j<sataPorts;j++)
			this.sataPorts[j]=new SataPort(this);
				
	}

	
	public void installIdeDevice(HddDrive drive, int portNumber)
	{
		if(portNumber<0 || portNumber>= idePorts.length)
		{
			System.out.println("\nNie ma takiego numeru portu.");
			return;
		}
		if(idePorts[portNumber].isAvaible())
			idePorts[portNumber].installDevice(drive);
		else
			System.out.println("\nSlot "+portNumber+" is not avaible.\n");
	}
	
	public void installSataDevice(SataHddDrive drive, int portNumber)
	{
		if(portNumber<0 || portNumber>= sataPorts.length)
		{
			System.out.println("\nNie ma takiego numeru portu.");
			return;
		}
		if(sataPorts[portNumber].isAvaible())
			sataPorts[portNumber].installDevice(drive);
		else
			System.out.println("\nSlot "+portNumber+" is not avaible.");
	}
	
	public void installSataDevice(CdRom cddrive, int portNumber)
	{
		if(portNumber<0 || portNumber>= sataPorts.length)
		{
			System.out.println("\nNie ma takiego numeru portu.");
			return;
		}
		if(sataPorts[portNumber].isAvaible())
			sataPorts[portNumber].installDevice(cddrive);
		else
			System.out.println("\nSlot "+portNumber+" is not avaible.");
	}
	
	
	public void installAgpGraphicCard(AgpGraphicCard agpGraphicCard)
	{
		if(agpSlot.isAvaible())
			agpSlot.installDevice(agpGraphicCard);
		else
			System.out.println("\nGraphic card is already installed.");
		
	}
	
	public void installPciExpressGraphicCard(PciExpressGraphicCard pciExpressGraphicCard)
	{
		if(pciExpressSlot.isAvaible())
			pciExpressSlot.installDevice(pciExpressGraphicCard);
		else
			System.out.println("\nGraphic card is already installed.");
	}
	
	public void installPciSlot(PciSlot pciSlot)
	{
		if(pciSlot.isAvaible())
			pciSlot.installDevice(pciSlot);
		else
			System.out.println("\nGraphic card is already installed.");
	}
	
	public void installLanCard(LanCard lanCard)
	{
		if(pciSlot.isAvaible())
			pciSlot.installDevice(lanCard);
		else
			System.out.println("\nLan card is already installed.");
	}
	
	public String getFullDescription()
	{
		String result;
		result="----------------------------\n";
		result=result + "Ide Devices: \n";
		for(int i=0;i<idePorts.length;i++)
		{
			result=result+"Port "+i+"\n"+idePorts[i].getDescription()+"\n";
		}
		result=result+"\n----------------------------\n";
		result=result + "Graphic Card: \n";
		result+=agpSlot.getDescription();
		
		result+="----------------------------\n";
		result=result + "Sata Devices: \n";
		for(int j=0;j<sataPorts.length;j++)
		{
			result=result+"Port "+j+"\n"+sataPorts[j].getDescription()+"\n";
		}
		result=result+"\n----------------------------\n";
		return result;
	}
}
