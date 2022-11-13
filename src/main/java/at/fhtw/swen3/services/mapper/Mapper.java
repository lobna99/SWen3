package at.fhtw.swen3.services.mapper;

public interface Mapper<S, T> {
    T sourceToTarget(S source);
    S TargetToSource(T target);
}