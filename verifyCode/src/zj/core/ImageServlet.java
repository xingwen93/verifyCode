package zj.core;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ZhangJing
 * @version 创建时间：2016年5月26日 下午5:22:28
 * 类说明
 */
public class ImageServlet extends BaseServlet{
	
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 120;
	public static final int HEIGHT = 30;
	/**
	 * 生成验证码
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @author ZhangJing
	 * @Date 2016年5月27日 上午9:07:12
	 */
	protected  void createImage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//接收客户端传递的createTypeFlag标识
		String createType = request.getParameter("createType");
		//1，在内存中创建一张图片
		BufferedImage bi = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		//2,得到图片
		Graphics g = bi.getGraphics();
		//3,设置图片的背景色
		setBackGroundColor(new Color(200,150,255), g);
		//4,设置边框
		setBorder(Color.BLUE, g);
		//5,画干扰线
		drawRandomLine(g);
		//6,写在图片上的随机数
		String randomNum = drawRandomChar((Graphics2D)g, createType);//根据客户端传递的createTypeFlag标识生成验证码图片
		System.out.println("randomNum:"+randomNum);
		//7,将随机数存在session 中
		request.getSession().setAttribute("checkcode", randomNum);
		//8,设置响应头通知浏览器以图片形式打开
		response.setContentType("image/jpeg");//等同于response.setHeader("Content-type","image/jpeg")
		//9,设置响应头控制浏览器不要缓存
		response.setDateHeader("expries", -1);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		//,将图片写给浏览器
		ImageIO.write(bi, "jpg", response.getOutputStream());
		
	}
	
	
	/**
	 * 设置图片的背景色
	 * @param c
	 * @param g
	 * @author ZhangJing
	 * @Date 2016年5月27日 上午9:35:03
	 */
	public void setBackGroundColor(Color c, Graphics g){
		//设置背景色
		g.setColor(c);
		//填充背景色
		g.fillRect(0, 0, WIDTH, HEIGHT);
	}
	
	/**
	 * 设置图片边框
	 * @param c
	 * @param g
	 * @author ZhangJing
	 * @Date 2016年5月27日 上午9:38:18
	 */
	public void setBorder(Color c,Graphics g){
		//设置边框颜色
		g.setColor(c);
		//边框区域
		g.drawRect(1, 1, WIDTH-2, HEIGHT-2);
	}
	
	/**
	 * 随机画干扰线条
	 * @param g
	 * @author ZhangJing
	 * @Date 2016年5月27日 上午9:39:18
	 */
	public void drawRandomLine(Graphics g){
		//设置线条颜色
		Color[] colors = {Color.GREEN,Color.BLACK,Color.BLUE,Color.ORANGE};
		//int c  = new Random().nextInt(colors.length-1);
		g.setColor(colors[0]);
		//设置线条条数并画线
		for (int i = 0; i < 5; i++) {
			int x1 = new Random().nextInt(WIDTH);
			int y1 = new Random().nextInt(HEIGHT);
			int x2 = new Random().nextInt(WIDTH);
			int y2 = new Random().nextInt(HEIGHT);
			g.drawLine(x1, y1, x2, y2);
		}
	}
	
	/**
	 * 画随机字符
	 * @param g
	 * @author ZhangJing
	 * @return 
	 * @Date 2016年5月27日 上午9:53:53
	 */
	public String drawRandomChar(Graphics2D g, String... createType){
		//设置颜色
		g.setColor(Color.RED);
		//设置字体
		g.setFont(new Font("宋体", Font.BOLD, 20));
		//数字和字母组合
		String baseNumLetter = "ABCDEFGHIGKLMNPQRSTUVWXYZabcdefghijklmnpqrstuvwxyz0123456789";
		//纯数字
		//String baseNum = "0123456789";
		//纯字母
		//String baseLetter = "ABCDEFGHIJKLMNPQRSTUVWXYZabcdefghijklmnpqrstuvwxyz";
		return createRandomChar(g, baseNumLetter);
	}
	
	/**
	 * 创建随机字符
	 * 可变参数：适用于参数个数不确定，类型确定的情况，java把可变参数当做数组处理。注意：可变参数必须位于最后一项
	 * @param g
	 * @param baseChar
	 * @return 随机字符
	 * @author ZhangJing
	 * @Date 2016年5月27日 上午10:01:31
  	*/
	public String createRandomChar(Graphics2D g, String baseChar){
		StringBuffer sb = new StringBuffer();
		int x = 5;
		String ch = "";
		//控制数字
		for(int i = 0;i<4; i++){
			//设置字体旋转角度
			int degree = new Random().nextInt() % 30;
			ch = baseChar.charAt(new Random().nextInt(baseChar.length()))+"";
			sb.append(ch);
			//正向角度
			g.rotate(degree * Math.PI / 180, x ,20);
			g.drawString(ch, x, 20);
			//反向角度
			g.rotate(-degree * Math.PI / 180, x, 20);
			x += 30;
		}
		return sb.toString();
	}
	
}
