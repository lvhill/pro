package cn.sky.framework.util.watermark;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * 图片水印文本样式
 * 
 * @author gflid
 *
 */
public class TextStyle {
	private static final Logger logger = LogManager.getLogger(TextStyle.class);

	/** 文字是否自动换行 */
	private boolean autoWrapText = true;

	/** 文本块左内边距 */
	private int paddingLeft = 0;

	/** 文本块右内边距 */
	private int paddingRight = 0;

	/** 文本块上内边距 */
	private int paddingTop = 0;

	/** 文本块下内边距 */
	private int paddingButtom = 0;

	/** 行距 */
	private int rowledge = 0;

	/** 字体 */
	private Font font = new Font("Microsoft YaHei", Font.PLAIN, 12);

	public final static String XFloatLeft = "x-float-left";
	public final static String XFloatRight = "x-float-right";
	public final static String XFloatCentre = "x-float-centre";

	/** 文本块横向float方向 */
	private String Xfloat = XFloatLeft;

	public final static String YFloatTop = "y-float-top";
	public final static String YFloatButtom = "y-float-buttom";
	public final static String YFloatCentre = "y-float-centre";

	/** 文本块垂直float方向 */
	private String Yfloat = YFloatTop;

	public final static String TextAlignLeft = "text-align-left";
	public final static String TextAlignRight = "text-align-right";
	public final static String TextAlignCentre = "text-align-centre";
	/** 文字对齐方向 */
	private String textAlign = TextAlignLeft;

	/** 字体颜色 */
	private Color fontColor = Color.BLACK;

	public boolean isAutoWrapText() {
		return autoWrapText;
	}

	public void setAutoWrapText(boolean autoWrapText) {
		this.autoWrapText = autoWrapText;
	}

	public int getPaddingLeft() {
		return paddingLeft;
	}

	public void setPaddingLeft(int paddingLeft) {
		this.paddingLeft = paddingLeft;
	}

	public int getPaddingRight() {
		return paddingRight;
	}

	public void setPaddingRight(int paddingRight) {
		this.paddingRight = paddingRight;
	}

	public int getPaddingTop() {
		return paddingTop;
	}

	public void setPaddingTop(int paddingTop) {
		this.paddingTop = paddingTop;
	}

	public int getPaddingButtom() {
		return paddingButtom;
	}

	public void setPaddingButtom(int paddingButtom) {
		this.paddingButtom = paddingButtom;
	}

	public int getRowledge() {
		return rowledge;
	}

	public void setRowledge(int rowledge) {
		this.rowledge = rowledge;
	}

	public Font getFont() {
		return font;
	}

	public void setFont(Font font) {
		this.font = font;
	}

	public String getXfloat() {
		return Xfloat;
	}

	public void setXfloat(String xfloat) {
		Xfloat = xfloat;
	}

	public String getYfloat() {
		return Yfloat;
	}

	public void setYfloat(String yfloat) {
		Yfloat = yfloat;
	}

	public String getTextAlign() {
		return textAlign;
	}

	public void setTextAlign(String textAlign) {
		this.textAlign = textAlign;
	}

	public Color getFontColor() {
		return fontColor;
	}

	public void setFontColor(Color fontColor) {
		this.fontColor = fontColor;
	}

	/**
	 * 初始化字体
	 * 
	 * @param name
	 *            字体名称
	 * @param style
	 *            字体样式
	 * @param size
	 *            字体大小
	 * @return
	 */
	public static Font initFont(String name, int style, float size) {
		Font font = null;
		String ttf = "/font/";// 字体ttf文件路径
		switch (name) {
		case "方正启体简体":
			ttf += "fzqj.ttf";
			break;
		default:// 微软雅黑
			ttf += "msyh.ttf";
			break;
		}
		logger.info("font ttf file: " + ttf);
		try {
			InputStream is = TextStyle.class.getResourceAsStream(ttf);
			BufferedInputStream fb = new BufferedInputStream(is);
			font = Font.createFont(Font.TRUETYPE_FONT, fb);
			font = font.deriveFont(style, size);
		} catch (FontFormatException e) {
			logger.error(e.getMessage());
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
		return font;
	}

}
