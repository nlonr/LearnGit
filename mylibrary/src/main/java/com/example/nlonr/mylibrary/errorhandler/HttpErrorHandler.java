package com.example.nlonr.mylibrary.errorhandler;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class HttpErrorHandler<T> implements Function<Throwable, Observable<T>> {
    @Override
    public io.reactivex.Observable<T> apply(Throwable throwable) throws Exception {
        return io.reactivex.Observable.error(ExceptionHandle.handleException(throwable));
    }
}
