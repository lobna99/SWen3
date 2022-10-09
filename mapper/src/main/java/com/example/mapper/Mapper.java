package com.example.mapper;

public interface Mapper<S,T>{

    T mapToTarget(S object);
    S mapToSource(T object);

}
