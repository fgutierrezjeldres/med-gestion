package cl.desarrollo.medgestion.service.impl;

import cl.desarrollo.medgestion.exception.ModelNotFoundException;
import cl.desarrollo.medgestion.repository.IGenericRepository;
import cl.desarrollo.medgestion.service.ICRUD;

import java.util.List;

public abstract class CRUDImpl<T, ID> implements ICRUD<T, ID> {

    //esto es polimorfismo
    protected abstract IGenericRepository<T,ID> getRepository();
    @Override
    public T save(T t) {
        return getRepository().save(t);
    }

    @Override
    public T update(T t, ID id) {
        getRepository().findById(id).orElseThrow(() -> new ModelNotFoundException("ID NOT FOUND" + id));
        return getRepository().save(t);
    }

    @Override
    public List<T> findAll() {
        return getRepository().findAll();
    }

    @Override
    public T findById(ID id) {
        //suplier = lamda
        return getRepository().findById(id).orElseThrow(() -> new ModelNotFoundException("ID NOT FOUND" + id));

    }

    @Override
    public void delete(ID id) {
        getRepository().findById(id).orElseThrow(() -> new ModelNotFoundException("ID NOT FOUND" + id));
        getRepository().deleteById(id);
    }
}
