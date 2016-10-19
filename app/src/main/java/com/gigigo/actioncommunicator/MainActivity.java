package com.gigigo.actioncommunicator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import com.gigigo.entities.BaseModuleActionData;
import com.gigigo.ocm.OcmModuleFactory;
import com.gigigo.ocm.entities.OcmActionType;
import com.gigigo.ocm.entities.OcmModuleActionData;
import com.gigigo.ox.OxModuleFactory;
import com.gigigo.ox.entities.OxActionType;
import com.gigigo.ox.entities.OxModuleActionData;

public class MainActivity extends AppCompatActivity {
  private OcmModuleFactory ocmModuleFactory;
  private OxModuleFactory oxModuleFactory;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    initOcm();
    initViews();
  }

  private void initOcm() {
    ocmModuleFactory = OcmModuleFactory.newInstance(this);
    oxModuleFactory = OxModuleFactory.newInstance(this);
  }

  private void initViews() {
    Button buttonOcmActionGoContent = (Button) findViewById(R.id.button_ocm_action_gocontent);
    buttonOcmActionGoContent.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        OcmModuleActionData actionData = new OcmModuleActionData();
        actionData.setActionType(OcmActionType.GO_CONTENT.toString());
        executeOcm(actionData);
      }
    });

    Button buttonOcmActionArticle = (Button) findViewById(R.id.button_ocm_action_article);
    buttonOcmActionArticle.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        OcmModuleActionData actionData = new OcmModuleActionData();
        actionData.setActionType(OcmActionType.ARTICLE.toString());
        executeOcm(actionData);
      }
    });

    Button buttonOcmActionImage = (Button) findViewById(R.id.button_ocm_action_image);
    buttonOcmActionImage.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        OcmModuleActionData actionData = new OcmModuleActionData();
        actionData.setActionType(OcmActionType.IMAGE.toString());
        executeOcm(actionData);
      }
    });

    Button buttonOcmActionVideo = (Button) findViewById(R.id.button_ocm_action_video);
    buttonOcmActionVideo.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        OcmModuleActionData actionData = new OcmModuleActionData();
        actionData.setActionType(OcmActionType.VIDEO.toString());
        executeOcm(actionData);
      }
    });

    Button buttonOcmActionWebview = (Button) findViewById(R.id.button_ocm_action_webview);
    buttonOcmActionWebview.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        OcmModuleActionData actionData = new OcmModuleActionData();
        actionData.setActionType(OcmActionType.WEBVIEW.toString());
        executeOcm(actionData);
      }
    });


    Button buttonOxActionScan = (Button) findViewById(R.id.button_ox_action_scan);
    buttonOxActionScan.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        OxModuleActionData actionData = new OxModuleActionData();
        actionData.setActionType(OxActionType.SCAN.toString());
        executeOx(actionData);
      }
    });

    Button buttonOxActionWebview = (Button) findViewById(R.id.button_ox_action_webview);
    buttonOxActionWebview.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        OxModuleActionData actionData = new OxModuleActionData();
        actionData.setActionType(OxActionType.WEBVIEW.toString());
        executeOx(actionData);
      }
    });
  }

  private void executeOcm(OcmModuleActionData actionData) {
    ocmModuleFactory.requestForExecute(actionData);
  }
  private void executeOx(OxModuleActionData actionData) {
    oxModuleFactory.requestForExecute(actionData);
  }
}
