package com.gigigo.ox.entities;

import com.gigigo.modulerouter.entities.BaseModuleActionData;
import com.gigigo.ox.OxModuleFactory;

/**
 * Created by rui.alonso on 19/10/16.
 */

public class OxModuleActionData extends BaseModuleActionData {

  public OxModuleActionData() {
    this.moduleName = OxModuleFactory.MODULE_NAME;
  }
}
