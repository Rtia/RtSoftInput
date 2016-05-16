package cn.rt.rtsoftinput;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

/**
 * Created by 饶天 on 2016/5/10.
 */
public class UiUtils {
    public static void inputDotTwo(final EditText et){
        et.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {

                /** 只可输入小数点后两位 */
                if (s.toString().trim().substring(0).equals(".")) {
                    s = "0" + s;
                    et.setText(s);
                    et.setSelection(2);
                }
                if (s.toString().contains(".")) {
                    if (s.length() - 1 - s.toString().indexOf(".") > 2) {
                        s = s.toString().subSequence(0, s.toString().indexOf(".") + 3);
                        et.setText(s);
                        et.setSelection(s.length());
                    }
                }
                Log.d("RT==", "s:" + s + " start:" + start + " before:" + before + " count:" + count);//TODO TEST
//                if (count != 0){
//                    if (s.toString().startsWith("0") && s.toString().trim().length() == 2) {
//                        if (!s.toString().contains(".")) {
//                            if (s.toString().startsWith("00")){
//                                et.setText(s.subSequence(0, 1));
//                                et.setSelection(1);
//                                return;
//                            } else {
//                                et.setText(s.subSequence(1, s.length()));
//                                et.setSelection(1);
//                                return;
//                            }
//                        }
//                    }
//                }

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
}
