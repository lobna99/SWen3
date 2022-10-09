package at.fhtw.swen3.services.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class AbstractMapper<S,T> implements Mapper<S,T> {

    public List<T> mapToTarget(Collection<S> object){
        List<T> target = new ArrayList<>();
        object.forEach(o -> target.add(mapToTarget(o)));
        return target;
    }

    public List<S> mapToSource(Collection<T> object){
        List<S> source = new ArrayList<>();
        object.forEach(o -> source.add(mapToSource(o)));
        return source;
    }
}
