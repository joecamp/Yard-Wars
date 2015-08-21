package View;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Model.SpecAbilityNode;
import Model.SpecialAbilities;

public class Animations {

	public static int animationOffset0x = MainView.frameWidth*3/200;
	public static int animationOffset0y = MainView.frameWidth*-2/100;
	public static int animationOffset1x = MainView.frameWidth*-1/100;
	public static int animationOffset1y = MainView.frameWidth*-1/100;
	public static int animationOffset2to3 = MainView.frameWidth*2/100;
	public static int animationOffset4to7 = MainView.frameWidth*2/100;
	public static int animationOffset8 = MainView.frameWidth*1/100;

	public static void drawAnimations(Graphics g) {
		for(SpecAbilityNode n : SpecialAbilities.currentAnimations) {
			if(n.specialAnimationID == 0) {
				switch(n.position) {
				case 1: g.drawImage(MainView.animations.get(0).get(n.specialAnimationTick), MainView.fieldSlot1x + animationOffset0x, MainView.fieldSlot135y + animationOffset0y, MainView.frame); break;
				case 2: g.drawImage(MainView.animations.get(0).get(n.specialAnimationTick), MainView.fieldSlot2x + animationOffset0x, MainView.fieldSlot24y + animationOffset0y, MainView.frame); break;
				case 3: g.drawImage(MainView.animations.get(0).get(n.specialAnimationTick), MainView.fieldSlot3x + animationOffset0x, MainView.fieldSlot135y + animationOffset0y, MainView.frame); break;
				case 4: g.drawImage(MainView.animations.get(0).get(n.specialAnimationTick), MainView.fieldSlot4x + animationOffset0x, MainView.fieldSlot24y + animationOffset0y, MainView.frame); break;
				case 5: g.drawImage(MainView.animations.get(0).get(n.specialAnimationTick), MainView.fieldSlot5x + animationOffset0x, MainView.fieldSlot135y + animationOffset0y, MainView.frame); break;
				case 6: g.drawImage(MainView.animations.get(0).get(n.specialAnimationTick), MainView.fieldSlot6x + animationOffset0x, MainView.fieldSlot6810y + animationOffset0y, MainView.frame); break;
				case 7: g.drawImage(MainView.animations.get(0).get(n.specialAnimationTick), MainView.fieldSlot7x + animationOffset0x, MainView.fieldSlot79y + animationOffset0y, MainView.frame); break;
				case 8: g.drawImage(MainView.animations.get(0).get(n.specialAnimationTick), MainView.fieldSlot8x + animationOffset0x, MainView.fieldSlot6810y + animationOffset0y, MainView.frame); break;
				case 9: g.drawImage(MainView.animations.get(0).get(n.specialAnimationTick), MainView.fieldSlot9x + animationOffset0x, MainView.fieldSlot79y + animationOffset0y, MainView.frame); break;
				case 10: g.drawImage(MainView.animations.get(0).get(n.specialAnimationTick), MainView.fieldSlot10x + animationOffset0x, MainView.fieldSlot6810y + animationOffset0y, MainView.frame); break;
				}
			}
			else if(n.specialAnimationID == 1) {
				switch(n.position) {
				case 1: g.drawImage(MainView.animations.get(n.specialAnimationID).get(n.specialAnimationTick), MainView.fieldSlot1x + animationOffset1x, MainView.fieldSlot135y + animationOffset1y, MainView.frame); break;
				case 2: g.drawImage(MainView.animations.get(n.specialAnimationID).get(n.specialAnimationTick), MainView.fieldSlot2x + animationOffset1x, MainView.fieldSlot24y + animationOffset1y, MainView.frame); break;
				case 3: g.drawImage(MainView.animations.get(n.specialAnimationID).get(n.specialAnimationTick), MainView.fieldSlot3x + animationOffset1x, MainView.fieldSlot135y + animationOffset1y, MainView.frame); break;
				case 4: g.drawImage(MainView.animations.get(n.specialAnimationID).get(n.specialAnimationTick), MainView.fieldSlot4x + animationOffset1x, MainView.fieldSlot24y + animationOffset1y, MainView.frame); break;
				case 5: g.drawImage(MainView.animations.get(n.specialAnimationID).get(n.specialAnimationTick), MainView.fieldSlot5x + animationOffset1x, MainView.fieldSlot135y + animationOffset1y, MainView.frame); break;
				case 6: g.drawImage(MainView.animations.get(n.specialAnimationID).get(n.specialAnimationTick), MainView.fieldSlot6x + animationOffset1x, MainView.fieldSlot6810y + animationOffset1y, MainView.frame); break;
				case 7: g.drawImage(MainView.animations.get(n.specialAnimationID).get(n.specialAnimationTick), MainView.fieldSlot7x + animationOffset1x, MainView.fieldSlot79y + animationOffset1y, MainView.frame); break;
				case 8: g.drawImage(MainView.animations.get(n.specialAnimationID).get(n.specialAnimationTick), MainView.fieldSlot8x + animationOffset1x, MainView.fieldSlot6810y + animationOffset1y, MainView.frame); break;
				case 9: g.drawImage(MainView.animations.get(n.specialAnimationID).get(n.specialAnimationTick), MainView.fieldSlot9x + animationOffset1x, MainView.fieldSlot79y + animationOffset1y, MainView.frame); break;
				case 10: g.drawImage(MainView.animations.get(n.specialAnimationID).get(n.specialAnimationTick), MainView.fieldSlot10x + animationOffset1x, MainView.fieldSlot6810y + animationOffset1y, MainView.frame); break;
				}
			}
			else if(n.specialAnimationID > 1 && n.specialAnimationID < 4) {
				switch(n.position) {
				case 1: g.drawImage(MainView.animations.get(n.specialAnimationID).get(n.specialAnimationTick), MainView.fieldSlot1x + animationOffset2to3, MainView.fieldSlot135y + animationOffset2to3, MainView.frame); break;
				case 2: g.drawImage(MainView.animations.get(n.specialAnimationID).get(n.specialAnimationTick), MainView.fieldSlot2x + animationOffset2to3, MainView.fieldSlot24y + animationOffset2to3, MainView.frame); break;
				case 3: g.drawImage(MainView.animations.get(n.specialAnimationID).get(n.specialAnimationTick), MainView.fieldSlot3x + animationOffset2to3, MainView.fieldSlot135y + animationOffset2to3, MainView.frame); break;
				case 4: g.drawImage(MainView.animations.get(n.specialAnimationID).get(n.specialAnimationTick), MainView.fieldSlot4x + animationOffset2to3, MainView.fieldSlot24y + animationOffset2to3, MainView.frame); break;
				case 5: g.drawImage(MainView.animations.get(n.specialAnimationID).get(n.specialAnimationTick), MainView.fieldSlot5x + animationOffset2to3, MainView.fieldSlot135y + animationOffset2to3, MainView.frame); break;
				case 6: g.drawImage(MainView.animations.get(n.specialAnimationID).get(n.specialAnimationTick), MainView.fieldSlot6x + animationOffset2to3, MainView.fieldSlot6810y + animationOffset2to3, MainView.frame); break;
				case 7: g.drawImage(MainView.animations.get(n.specialAnimationID).get(n.specialAnimationTick), MainView.fieldSlot7x + animationOffset2to3, MainView.fieldSlot79y + animationOffset2to3, MainView.frame); break;
				case 8: g.drawImage(MainView.animations.get(n.specialAnimationID).get(n.specialAnimationTick), MainView.fieldSlot8x + animationOffset2to3, MainView.fieldSlot6810y + animationOffset2to3, MainView.frame); break;
				case 9: g.drawImage(MainView.animations.get(n.specialAnimationID).get(n.specialAnimationTick), MainView.fieldSlot9x + animationOffset2to3, MainView.fieldSlot79y + animationOffset2to3, MainView.frame); break;
				case 10: g.drawImage(MainView.animations.get(n.specialAnimationID).get(n.specialAnimationTick), MainView.fieldSlot10x + animationOffset2to3, MainView.fieldSlot6810y + animationOffset2to3, MainView.frame); break;
				}
			}
			else if(n.specialAnimationID == 8){
				switch(n.position) {
				case 1: g.drawImage(MainView.animations.get(n.specialAnimationID).get(n.specialAnimationTick), MainView.fieldSlot1x + animationOffset8, MainView.fieldSlot135y + animationOffset4to7, MainView.frame); break;
				case 2: g.drawImage(MainView.animations.get(n.specialAnimationID).get(n.specialAnimationTick), MainView.fieldSlot2x + animationOffset8, MainView.fieldSlot24y + animationOffset4to7, MainView.frame); break;
				case 3: g.drawImage(MainView.animations.get(n.specialAnimationID).get(n.specialAnimationTick), MainView.fieldSlot3x + animationOffset8, MainView.fieldSlot135y + animationOffset4to7, MainView.frame); break;
				case 4: g.drawImage(MainView.animations.get(n.specialAnimationID).get(n.specialAnimationTick), MainView.fieldSlot4x + animationOffset8, MainView.fieldSlot24y + animationOffset4to7, MainView.frame); break;
				case 5: g.drawImage(MainView.animations.get(n.specialAnimationID).get(n.specialAnimationTick), MainView.fieldSlot5x + animationOffset8, MainView.fieldSlot135y + animationOffset4to7, MainView.frame); break;
				case 6: g.drawImage(MainView.animations.get(n.specialAnimationID).get(n.specialAnimationTick), MainView.fieldSlot6x + animationOffset8, MainView.fieldSlot6810y + animationOffset4to7, MainView.frame); break;
				case 7: g.drawImage(MainView.animations.get(n.specialAnimationID).get(n.specialAnimationTick), MainView.fieldSlot7x + animationOffset8, MainView.fieldSlot79y + animationOffset4to7, MainView.frame); break;
				case 8: g.drawImage(MainView.animations.get(n.specialAnimationID).get(n.specialAnimationTick), MainView.fieldSlot8x + animationOffset8, MainView.fieldSlot6810y + animationOffset4to7, MainView.frame); break;
				case 9: g.drawImage(MainView.animations.get(n.specialAnimationID).get(n.specialAnimationTick), MainView.fieldSlot9x + animationOffset8, MainView.fieldSlot79y + animationOffset4to7, MainView.frame); break;
				case 10: g.drawImage(MainView.animations.get(n.specialAnimationID).get(n.specialAnimationTick), MainView.fieldSlot10x + animationOffset8, MainView.fieldSlot6810y + animationOffset4to7, MainView.frame); break;
				}
			}
			else {
				switch(n.position) {
				case 1: g.drawImage(MainView.animations.get(n.specialAnimationID).get(n.specialAnimationTick), MainView.fieldSlot1x + animationOffset4to7, MainView.fieldSlot135y + animationOffset4to7, MainView.frame); break;
				case 2: g.drawImage(MainView.animations.get(n.specialAnimationID).get(n.specialAnimationTick), MainView.fieldSlot2x + animationOffset4to7, MainView.fieldSlot24y + animationOffset4to7, MainView.frame); break;
				case 3: g.drawImage(MainView.animations.get(n.specialAnimationID).get(n.specialAnimationTick), MainView.fieldSlot3x + animationOffset4to7, MainView.fieldSlot135y + animationOffset4to7, MainView.frame); break;
				case 4: g.drawImage(MainView.animations.get(n.specialAnimationID).get(n.specialAnimationTick), MainView.fieldSlot4x + animationOffset4to7, MainView.fieldSlot24y + animationOffset4to7, MainView.frame); break;
				case 5: g.drawImage(MainView.animations.get(n.specialAnimationID).get(n.specialAnimationTick), MainView.fieldSlot5x + animationOffset4to7, MainView.fieldSlot135y + animationOffset4to7, MainView.frame); break;
				case 6: g.drawImage(MainView.animations.get(n.specialAnimationID).get(n.specialAnimationTick), MainView.fieldSlot6x + animationOffset4to7, MainView.fieldSlot6810y + animationOffset4to7, MainView.frame); break;
				case 7: g.drawImage(MainView.animations.get(n.specialAnimationID).get(n.specialAnimationTick), MainView.fieldSlot7x + animationOffset4to7, MainView.fieldSlot79y + animationOffset4to7, MainView.frame); break;
				case 8: g.drawImage(MainView.animations.get(n.specialAnimationID).get(n.specialAnimationTick), MainView.fieldSlot8x + animationOffset4to7, MainView.fieldSlot6810y + animationOffset4to7, MainView.frame); break;
				case 9: g.drawImage(MainView.animations.get(n.specialAnimationID).get(n.specialAnimationTick), MainView.fieldSlot9x + animationOffset4to7, MainView.fieldSlot79y + animationOffset4to7, MainView.frame); break;
				case 10: g.drawImage(MainView.animations.get(n.specialAnimationID).get(n.specialAnimationTick), MainView.fieldSlot10x + animationOffset4to7, MainView.fieldSlot6810y + animationOffset4to7, MainView.frame); break;
				}
			}
			if(n.specialAnimationTick == (MainView.animations.get(n.specialAnimationID).size() - 1)) {
				n.specialAnimationTick = 0;
			}
			else {
				n.specialAnimationTick++;
			}
		}
		MainView.specialAnimationTimeStart++;
	}
	
	public static void populateAnimations() {
		try{
			for(int i = 0; i < 24; i++) {
			MainView.tempBufferedImage = ImageIO.read(new File("Images/Ability_Animations/0/" + i + ".png"));
			MainView.tempAni0.add(MainView.getScaledImage(MainView.tempBufferedImage, MainView.cardWidth, MainView.cardHeight));
			}
			MainView.animations.add(0, MainView.tempAni0);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try{
			for(int i = 0; i < 27; i++) {
				MainView.tempBufferedImage = ImageIO.read(new File("Images/Ability_Animations/1/" + i + ".png"));
				MainView.tempAni1.add(MainView.getScaledImage(MainView.tempBufferedImage, MainView.cardWidth, MainView.cardHeight));
			}
			MainView.animations.add(1, MainView.tempAni1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try{
			for(int i = 0; i < 28; i++) {
				MainView.tempBufferedImage = ImageIO.read(new File("Images/Ability_Animations/2/" + i + ".png"));
				MainView.tempAni2.add(MainView.tempBufferedImage);
			}
			MainView.animations.add(2, MainView.tempAni2);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try{
			for(int i = 0; i < 6; i++) {
				MainView.tempBufferedImage = ImageIO.read(new File("Images/Ability_Animations/3/" + i + ".png"));
				MainView.tempAni3.add(MainView.getScaledImage(MainView.tempBufferedImage, MainView.cardWidth*1/2, MainView.cardHeight*1/2));
			}
			MainView.animations.add(3, MainView.tempAni3);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try{
			MainView.tempBufferedImage = ImageIO.read(new File("Images/Ability_Animations/4/0.png"));
			MainView.tempAni4.add(MainView.getScaledImage(MainView.tempBufferedImage, MainView.cardWidth*3/5, MainView.cardHeight*3/5));
			MainView.animations.add(MainView.tempAni4);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try{
			MainView.tempBufferedImage = ImageIO.read(new File("Images/Ability_Animations/5/0.png"));
			MainView.tempAni5.add(MainView.getScaledImage(MainView.tempBufferedImage, MainView.cardWidth*46/100, MainView.cardHeight*46/100));
			MainView.animations.add(5, MainView.tempAni5);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try{
			MainView.tempBufferedImage = ImageIO.read(new File("Images/Ability_Animations/6/0.png"));
			MainView.tempAni6.add(MainView.getScaledImage(MainView.tempBufferedImage, MainView.cardWidth*46/100, MainView.cardHeight*46/100));
			MainView.animations.add(6, MainView.tempAni6);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try{
			MainView.tempBufferedImage = ImageIO.read(new File("Images/Ability_Animations/7/0.png"));
			MainView.tempAni7.add(MainView.getScaledImage(MainView.tempBufferedImage, MainView.cardWidth*3/5, MainView.cardHeight*3/5));
			MainView.animations.add(7, MainView.tempAni7);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try{
			MainView.tempBufferedImage = ImageIO.read(new File("Images/Ability_Animations/8/0.png"));
			MainView.tempAni8.add(MainView.getScaledImage(MainView.tempBufferedImage, MainView.cardWidth*3/5, MainView.cardHeight*3/5));
			MainView.animations.add(8, MainView.tempAni8);
		} catch (IOException e) {
			e.printStackTrace();
		}
}
	
}
