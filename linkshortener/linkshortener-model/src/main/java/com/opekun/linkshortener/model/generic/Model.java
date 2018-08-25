package com.opekun.linkshortener.model.generic;

import java.io.Serializable;

public abstract class Model implements Serializable {

    private static final long serialVersionUID = -8159395521414677065L;

    public abstract Long getId();

    public abstract void setId(Long id);

}
