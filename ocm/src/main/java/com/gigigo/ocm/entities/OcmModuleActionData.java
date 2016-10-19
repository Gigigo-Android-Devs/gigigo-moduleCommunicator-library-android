package com.gigigo.ocm.entities;

import com.gigigo.entities.BaseModuleActionData;
import com.gigigo.ocm.OcmModuleFactory;

/**
 * Created by rui.alonso on 19/10/16.
 */

public class OcmModuleActionData extends BaseModuleActionData {

  public OcmModuleActionData() {
    this.moduleName = OcmModuleFactory.MODULE_NAME;
  }
}
