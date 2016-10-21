package com.gigigo.ocm.mappers;

import com.gigigo.ggglib.mappers.Mapper;
import com.gigigo.modulerouter.router.BaseModuleActionData;
import com.gigigo.ocm.entities.OcmModuleActionData;

/**
 * Created by rui.alonso on 20/10/16.
 */

public class OcmActionDataMapper
    implements Mapper<OcmModuleActionData, BaseModuleActionData> {

  @Override public OcmModuleActionData externalClassToModel(BaseModuleActionData baseModuleActionData) {
    OcmModuleActionData ocmModuleActionData = new OcmModuleActionData();
    ocmModuleActionData.setModuleName(baseModuleActionData.getModuleName());
    ocmModuleActionData.setActionType(baseModuleActionData.getActionType());
    ocmModuleActionData.setUrl(baseModuleActionData.getUrl());

    return ocmModuleActionData;
  }

  @Override
  public BaseModuleActionData modelToExternalClass(OcmModuleActionData ocmModuleActionData) {
    BaseModuleActionData baseModuleActionData = new BaseModuleActionData();
    baseModuleActionData.setModuleName(ocmModuleActionData.getModuleName());
    baseModuleActionData.setActionType(ocmModuleActionData.getActionType());
    baseModuleActionData.setUrl(ocmModuleActionData.getUrl());

    return baseModuleActionData;
  }
}

