package cn.lhy.springMVC.customEditor;

import java.beans.PropertyEditorSupport;

/**
 * 自定义数据编辑器中的Double编辑器，实现以下目标：
 * 在表单中提交身高数据的时候，把身高+0.1m
 */
public class MyDoubleEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (null==text || "".equals(text)){
            text = "0"
;        }
        text = Double.parseDouble(text) + 0.1 + "";
        super.setValue(text);
    }
}
