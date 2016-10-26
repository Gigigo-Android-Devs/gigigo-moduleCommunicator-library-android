package com.gigigo.ocm.entities;

import java.util.List;

/**
 * Created by rui.alonso on 19/10/16.
 */

public class OcmActionData {
  private String slug;
  private String type;
  private List<String> tags;
  private String preview;
  private String render;

  public String getSlug() {
    return slug;
  }

  public void setSlug(String slug) {
    this.slug = slug;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public List<String> getTags() {
    return tags;
  }

  public void setTags(List<String> tags) {
    this.tags = tags;
  }

  public String getPreview() {
    return preview;
  }

  public void setPreview(String preview) {
    this.preview = preview;
  }

  public String getRender() {
    return render;
  }

  public void setRender(String render) {
    this.render = render;
  }
}
