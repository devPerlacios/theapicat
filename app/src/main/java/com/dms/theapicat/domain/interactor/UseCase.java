package com.dms.theapicat.domain.interactor;

import com.dms.theapicat.domain.Handler;

public interface UseCase<T, P> {

    void execute(Handler<T> handler, P params);

}
