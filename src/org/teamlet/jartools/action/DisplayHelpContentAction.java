package org.teamlet.jartools.action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

import org.teamlet.jartools.ui.GUIConstant;
import org.teamlet.jartools.ui.GUIContext;

/**
 * ��ʾ��������
 * 
 * @author <a href="mailto:teamlet@gmail.com">David</a>
 * 
 */
public class DisplayHelpContentAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5384279149121510493L;

	public DisplayHelpContentAction(String text, Icon icon) {
		super(text, icon);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		StyledDocument document = (StyledDocument) GUIContext.get(GUIConstant.DOCUMENT);
		Style style = document.getStyle(StyleContext.DEFAULT_STYLE);
		StyleConstants.setAlignment(style, StyleConstants.ALIGN_LEFT);
		StyleConstants.setFontSize(style, 20);
		StyleConstants.setSpaceAbove(style, 4);
		StyleConstants.setSpaceBelow(style, 4);
		StyleConstants.setBold(style, true);
		String info = "������Ϣ";
		boolean clean = false;
		if (!clean) {
			try {
				document.remove(0, document.getLength());
			} catch (BadLocationException badLocationException) {
				badLocationException.printStackTrace();
			}
			clean = true;
		}
		outputMessage(document, style, info);
		StyleConstants.setFontSize(style, 14);
		StyleConstants.setBold(style, false);
		info = "\nWhereIsClass��һ����jar�в���class�Ĺ��ߣ�����ͨ���ؼ��ֲ����ڵ��������ļ���������jar��ƥ����ࡣ";
		info = info + "\n��Ҫ�Ĳ�������������һ����·����������һ�����ϵ�·����·��֮���÷ֺ�(\";\")������";
		info = info + "\n�ڶ����ǹؼ��֣�Ҳ����Ҫ���ҵ�������֡��ؼ��ֿ�����Ҫ���ҵ�������һ���֣�֧��ģ��ƥ�䡣";
		info = info + "\nͨ��ѡ�������Զ��ѡ��·����·�����Զ��ۼӡ����Ҫ���·�������������ť��";
		outputMessage(document, style, info);

		info = "\n��ǰ�汾";
		StyleConstants.setBold(style, true);
		StyleConstants.setFontSize(style, 20);
		outputMessage(document, style, info);

		info = "\nͼ��ģʽ��";
		info = info + "\nGUI V1.0 2012-05-02";
		StyleConstants.setBold(style, false);
		StyleConstants.setFontSize(style, 14);
		outputMessage(document, style, info);

		info = "\n������ʷ";
		StyleConstants.setBold(style, true);
		StyleConstants.setFontSize(style, 20);
		outputMessage(document, style, info);

		info = "\nͼ��ģʽ��";
		info = info + "\nGUI V1.0 2012-05-02";
		info = info + "\nGUI V0.1 2010-06-23";
		info = info + "\n������ģʽ��";
		info = info + "\nV0.2 2010-06-23";
		info = info + "\nV0.1 2010-06-22";
		StyleConstants.setFontSize(style, 14);
		StyleConstants.setBold(style, false);
		outputMessage(document, style, info);

		info = "\n���ⷴ����";
		StyleConstants.setBold(style, true);
		StyleConstants.setFontSize(style, 20);
		outputMessage(document, style, info);

		info = "\n���ʼ�����";
		info = info + "\nteamlet@gmail.com";
		info = info + "\nhttp://code.google.com/p/whereisclass/";

		StyleConstants.setFontSize(style, 14);
		StyleConstants.setBold(style, false);
		outputMessage(document, style, info);

	}

	private void outputMessage(StyledDocument document, Style style, String info) {
		try {
			document.insertString(document.getLength(), info, style);
		} catch (BadLocationException badLocationException) {
			badLocationException.printStackTrace();
		}
	}
}