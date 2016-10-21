package com.gigigo.actioncommunicator;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.gigigo.modulerouter.entities.BaseModuleActionData;
import com.gigigo.ocm.OcmModuleFactory;
import com.gigigo.ocm.entities.OcmActionType;
import com.gigigo.ocm.entities.OcmModuleActionData;
import com.gigigo.ocm.executor.OcmModuleActionExecutor;
import com.gigigo.ocm.mappers.OcmActionDataMapper;
import com.gigigo.ox.OxModuleFactory;
import com.gigigo.ox.entities.OxActionType;
import com.gigigo.ox.entities.OxModuleActionData;
import com.gigigo.ox.executor.OxModuleActionExecutor;
import com.gigigo.ox.mappers.OxActionDataMapper;

public class MainActivity extends AppCompatActivity {
  private OcmModuleFactory ocmModuleFactory;
  private OxModuleFactory oxModuleFactory;

  private OcmActionDataMapper ocmActionDataMapper;
  private OxActionDataMapper oxActionDataMapper;

  private TextView ocmTextResponse;
  private TextView oxTextResponse;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    initModules();
    initReceivers();
    initViews();
  }

  private void initModules() {
    ocmModuleFactory = OcmModuleFactory.newInstance(this);
    oxModuleFactory = OxModuleFactory.newInstance(this);

    ocmActionDataMapper = new OcmActionDataMapper();
    oxActionDataMapper = new OxActionDataMapper();
  }

  private void initReceivers() {
    setOcmReceiver();
    setOxReceiver();
  }

  private void setOcmReceiver() {
    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction(OcmModuleActionExecutor.BROADCAST_ACTION);
    BroadcastReceiver ocmBroadcastReceiver = new BroadcastReceiver() {

      @Override public void onReceive(Context context, Intent intent) {
        final String action = intent.getAction();
        if (action.equals(OcmModuleActionExecutor.BROADCAST_ACTION)) {
          BaseModuleActionData data = intent.getParcelableExtra(OcmModuleActionExecutor.EXTRA_DATA);
          OcmModuleActionData ocmData = ocmActionDataMapper.externalClassToModel(data);
          ocmTextResponse.setText(ocmData.getActionType());
        }
      }
    };
    registerReceiver(ocmBroadcastReceiver, intentFilter);
  }

  private void setOxReceiver() {
    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction(OxModuleActionExecutor.BROADCAST_ACTION);
    BroadcastReceiver ocmBroadcastReceiver = new BroadcastReceiver() {

      @Override public void onReceive(Context context, Intent intent) {
        final String action = intent.getAction();
        if (action.equals(OxModuleActionExecutor.BROADCAST_ACTION)) {
          BaseModuleActionData data = intent.getParcelableExtra(OxModuleActionExecutor.EXTRA_DATA);
          OxModuleActionData oxData = oxActionDataMapper.externalClassToModel(data);
          oxTextResponse.setText(oxData.getActionType());
        }
      }
    };
    registerReceiver(ocmBroadcastReceiver, intentFilter);
  }

  private void initViews() {
    ocmTextResponse = (TextView) findViewById(R.id.ocm_text_response);

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

    oxTextResponse = (TextView) findViewById(R.id.ox_text_response);

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
    ocmTextResponse.setText("");
  }

  private void executeOx(OxModuleActionData actionData) {
    oxModuleFactory.requestForExecute(actionData);
    oxTextResponse.setText("");
  }
}
