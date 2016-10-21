package com.gigigo.ox.mappers;

import com.gigigo.ggglib.mappers.Mapper;
import com.gigigo.modulerouter.entities.BaseModuleActionData;
import com.gigigo.ox.entities.OxModuleActionData;

/**
 * Created by rui.alonso on 20/10/16.
 */

public class OxActionDataMapper implements Mapper<OxModuleActionData, BaseModuleActionData> {

  @Override public OxModuleActionData externalClassToModel(BaseModuleActionData baseModuleActionData) {
    OxModuleActionData oxModuleActionData = new OxModuleActionData();
    oxModuleActionData.setModuleName(baseModuleActionData.getModuleName());
    oxModuleActionData.setActionType(baseModuleActionData.getActionType());
    oxModuleActionData.setUrl(baseModuleActionData.getUrl());

    return oxModuleActionData;
  }

  @Override
  public BaseModuleActionData modelToExternalClass(OxModuleActionData oxModuleActionData) {
    BaseModuleActionData baseModuleActionData = new BaseModuleActionData();
    baseModuleActionData.setModuleName(oxModuleActionData.getModuleName());
    baseModuleActionData.setActionType(oxModuleActionData.getActionType());
    baseModuleActionData.setUrl(oxModuleActionData.getUrl());

    return baseModuleActionData;
  }
}

