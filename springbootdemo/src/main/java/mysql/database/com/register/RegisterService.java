package mysql.database.com.register;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

@Service
public class RegisterService {
//	private final String DIR = "C:\\QRCODE\\AllEmptyQrCodes\\";
//    private final String ext = ".png";
//    private final String LOGO = "file:\\e:\\desai2\\final1.PNG";
//    private final String CONTENT = "sub-6";
//    private final int WIDTH = 500;
//    private final int HEIGHT = 500;

	@Autowired
	private RegisterRepository registerRepo;
	
	
	public void newRegisteration(RegisterModel obj){
		registerRepo.save(obj);
	}
	
	public void updateRegisteration(RegisterModel obj,String id){
		registerRepo.save(obj);
	}
	
	public List<RegisterModel> show_allRegisteration(){
		List<RegisterModel> reg = new ArrayList<>();
		registerRepo.findAll().forEach(reg::add);
		return reg;
	}
	
	public Optional<RegisterModel> show_oneRegisteration(String id){
		return registerRepo.findById(id);
	}
	
	public void deleteRegisteration(String id){
		registerRepo.deleteById(id);
	}
	

//	final qr code for subject ID
	
//	public void demo2qrcodetext(){
//		String DIR = "";
//	    String ext = ".png";
//	    String LOGO = "file:\\e:\\desai2\\final1.PNG";
//	    String CONTENT = "sub-2";
//	    int WIDTH = 500;
//	    int HEIGHT = 500;
//
//	    
//	    
//	    String subjectfold="C:\\QRCODE\\";
//		
//		File f = new File("C:\\QRCODE");
//		if(!f.exists()) {
//			f.mkdir();
//		}
//		String profold="C:\\QRCODE\\";
//		String pfold=profold.concat("B");
//		File f1 = new File(pfold);
//		if(!f1.exists()) {
//			f1.mkdir();
//		}
//			String subfold=pfold.concat("\\SubjectIdCards\\");
//			File f3 = new File(subfold);
//			if(!f3.exists()) {
//				f3.mkdir();
//			}
//			DIR=subfold;
//	          // Create new configuration that specifies the error correction
//	          Map<EncodeHintType, ErrorCorrectionLevel> hints = new HashMap<>();
//	          hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
//
//	          QRCodeWriter writer = new QRCodeWriter();
//	          BitMatrix bitMatrix = null;
//	          ByteArrayOutputStream os = new ByteArrayOutputStream();
//
//	          try {
//	              bitMatrix = writer.encode(CONTENT, BarcodeFormat.QR_CODE, WIDTH, HEIGHT, hints);
//	              // Load QR image
//	              BufferedImage qrImage = MatrixToImageWriter.toBufferedImage(bitMatrix, getMatrixConfig());
//	              // Load logo image
//	              BufferedImage overly = getOverly(LOGO);
//	              Graphics g1 = overly.getGraphics();
//	              g1.setFont(g1.getFont().deriveFont(20f));
//	              g1.drawString(CONTENT, 255, 255);
//	              g1.dispose();
//	              // Calculate the delta height and width between QR code and logo
//	              int deltaHeight = qrImage.getHeight() - overly.getHeight();
//	              int deltaWidth = qrImage.getWidth() - overly.getWidth();
//	              // Initialize combined image
//	              BufferedImage combined = new BufferedImage(qrImage.getHeight(), qrImage.getWidth(), BufferedImage.TYPE_INT_ARGB);
//	              Graphics2D g = (Graphics2D) combined.getGraphics();
//	              // Write QR code to new image at position 0/0
//	              g.drawImage(qrImage, 0, 0, null);
//	              g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
//	              // Write logo into combine image at position (deltaWidth / 2) and
//	              g.drawImage(overly, (int) Math.round(deltaWidth / 2), (int) Math.round(deltaHeight / 2), null);
//	              // Write combined image as PNG to OutputStream
//	              ImageIO.write(combined, "png", os);
//	              // Store Image
//	              Files.copy( new ByteArrayInputStream(os.toByteArray()), Paths.get(DIR + CONTENT +ext), StandardCopyOption.REPLACE_EXISTING);
//
//	          } catch (WriterException e) {
//	              e.printStackTrace();
//	          } catch (IOException e) {
//	              e.printStackTrace();
//	          }
//	      }
	
	
	
	public void smallqrcodetext(){
		String DIR = "";
	    String ext = ".png";
	    String LOGO = "file:\\e:\\desai2\\final.PNG";
	    String CONTENT = "536478753734";
	    int WIDTH = 100;
	    int HEIGHT = 100;

	    
	    
	    String subjectfold="C:\\QRCODE\\";
		
		File f = new File("C:\\QRCODE");
		if(!f.exists()) {
			f.mkdir();
		}
		String profold="C:\\QRCODE\\";
		String pfold=profold.concat("C");
		File f1 = new File(pfold);
		if(!f1.exists()) {
			f1.mkdir();
		}
			String subfold=pfold.concat("\\SubjectIdCards\\");
			File f3 = new File(subfold);
			if(!f3.exists()) {
				f3.mkdir();
			}
			DIR=subfold;
	          // Create new configuration that specifies the error correction
	          Map<EncodeHintType, ErrorCorrectionLevel> hints = new HashMap<>();
	          hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);

	          QRCodeWriter writer = new QRCodeWriter();
	          BitMatrix bitMatrix = null;
	          ByteArrayOutputStream os = new ByteArrayOutputStream();

	          try {
	              bitMatrix = writer.encode(CONTENT, BarcodeFormat.QR_CODE, WIDTH, HEIGHT, hints);
	              // Load QR image
	              BufferedImage qrImage = MatrixToImageWriter.toBufferedImage(bitMatrix, getMatrixConfig());
	              // Load logo image
	              BufferedImage overly = getOverly(LOGO);
	              Graphics g1 = overly.getGraphics();
	              g1.setFont(g1.getFont().deriveFont(10f));
	              g1.drawString(CONTENT, 255, 255);
	              g1.dispose();
	              // Calculate the delta height and width between QR code and logo
	              int deltaHeight = qrImage.getHeight() - overly.getHeight();
	              int deltaWidth = qrImage.getWidth() - overly.getWidth();
	              // Initialize combined image
	              BufferedImage combined = new BufferedImage(qrImage.getHeight(), qrImage.getWidth(), BufferedImage.TYPE_INT_ARGB);
	              Graphics2D g = (Graphics2D) combined.getGraphics();
	              // Write QR code to new image at position 0/0
	              g.drawImage(qrImage, 0, 0, null);
	              g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
	              // Write logo into combine image at position (deltaWidth / 2) and
	              g.drawImage(overly, (int) Math.round(deltaWidth / 2), (int) Math.round(deltaHeight / 2), null);
	              // Write combined image as PNG to OutputStream
	              ImageIO.write(combined, "png", os);
	              // Store Image
	              Files.copy( new ByteArrayInputStream(os.toByteArray()), Paths.get(DIR + CONTENT +ext), StandardCopyOption.REPLACE_EXISTING);

	          } catch (WriterException e) {
	              e.printStackTrace();
	          } catch (IOException e) {
	              e.printStackTrace();
	          }
	      }
	
	
	
	
	
	
	
	
	
	
	
//	common method for any qr Code
	

	      private BufferedImage getOverly(String LOGO) throws IOException {
	          URL url = new URL(LOGO);
	          return ImageIO.read(url);
	      }
	      
	      private MatrixToImageConfig getMatrixConfig() {
	          return new MatrixToImageConfig(RegisterService.Colors.BLACK.getArgb(), RegisterService.Colors.WHITE.getArgb());
	      }

	      public enum Colors {

	          BLUE(0xFF40BAD0),
	          RED(0xFFE91C43),
	          PURPLE(0xFF8A4F9E),
	          ORANGE(0xFFF4B13D),
	          WHITE(0xFFFFFFFF),
	          BLACK(0xFF000000);

	          private final int argb;

	          Colors(final int argb){
	              this.argb = argb;
	          }

	          public int getArgb(){
	              return argb;
	          }
	}
}
