package com.android.testdai.application.ui.main;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.android.testdai.R;
import com.android.testdai.application.ui.main.abstraction.IMainView;
import com.android.testdai.application.ui.test.TestActivity;
import com.android.testdai.application.ui.dialog.DialogCategory;
import com.android.testdai.util.Constants;

import static com.android.testdai.util.Constants.APP_PREFERENCES_CATEGORY;

public class MainActivity extends AppCompatActivity  implements IMainView {

    private Button mCategory;
    private MainPresenter presenter;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(this);

        Button mStartTest = (Button) findViewById(R.id.start_test);
        mStartTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.startTest();
            }
        });

        mCategory = (Button) findViewById(R.id.category);
//        if (mSettings.contains(APP_PREFERENCES_CATEGORY)) {
//            updateUI();
//        }
        mCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.startDialogCategory();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.attachView();
    }


    @Override
    public void updateUI(String category) {
        mCategory.setText(category);
    }

    @Override
    public void startDialogCategory(String category) {

        DialogCategory dialog = DialogCategory
                .newInstance(category);
        dialog.show(getFragmentManager(), Constants.DIALOG_CATEGORY);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        presenter.onActivityResult(requestCode, resultCode, intent);
    }

}