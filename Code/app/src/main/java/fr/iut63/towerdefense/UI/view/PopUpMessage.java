package fr.iut63.towerdefense.UI.view;

import android.app.Activity;
import android.app.Dialog;
import android.widget.Button;
import android.widget.TextView;

import fr.iut63.towerdefense.R;


public class PopUpMessage extends Dialog {

    private String title;
    private String subTitle;
    private Button yesButton;
    private TextView titleView,subTitleView;

    public PopUpMessage(Activity activity){
        super(activity, R.style.Theme_AppCompat_DayNight_Dialog);
        setContentView(R.layout.my_popup);
        this.title = "Mon titre";
        this.subTitle = "Mon sous titre";
        this.yesButton = findViewById(R.id.yesButton);
        this.titleView = findViewById(R.id.title);
        this.subTitleView = findViewById(R.id.subTitle);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public Button getYesButton(){ return yesButton; }

    public void build(){
        show();
        titleView.setText(title);
        subTitleView.setText(subTitle);
    }

}
