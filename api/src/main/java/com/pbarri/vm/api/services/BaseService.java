package com.pbarri.vm.api.services;

import com.pbarri.vm.api.model.BaseEntity;
import org.hibernate.service.spi.ServiceException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by pablo on 13/12/16.
 */
@Transactional
public abstract class BaseService<T extends BaseEntity, I extends Serializable> {

    public abstract JpaRepository<T, I> getRepository();


    /**
     * Returns all instances of the type.
     *
     * @return all entities
     */
    public List<T> findAll() throws ServiceException {
        return getRepository().findAll();
    }

    /**
     * Returns all entities sorted by the given options.
     *
     * @param sort
     *            Ordenación de la consulta
     * @return all entities sorted by the given options
     */
    public List<T> findAll(Sort sort) throws ServiceException {
        return getRepository().findAll(sort);
    }

    /**
     * Returns a {@link Page} of entities meeting the paging restriction provided in the {@code Pageable} object.
     *
     * @param pageable
     *            Página de la consulta
     * @return a page of entities
     */
    public Page<T> findAll(Pageable pageable) throws ServiceException {
        return getRepository().findAll(pageable);
    }

    /**
     * Returns all instances of the type with the given IDs.
     *
     * @param ids
     *            de los objetos a buscar
     * @return Lista con todos los registros encontrados
     */
    public List<T> findAll(Iterable<I> ids) throws ServiceException {
        return getRepository().findAll(ids);
    }

    /**
     * Returns the number of entities available.
     *
     * @return the number of entities
     */
    public long count() throws ServiceException {
        return getRepository().count();
    }

    /**
     * Deletes the entity with the given id.
     *
     * @param id
     *            must not be {@literal null}.
     * @throws IllegalArgumentException
     *             in case the given {@code id} is {@literal null}
     */
    public void delete(I id) throws ServiceException {
        getRepository().delete(id);
    }

    /**
     * Deletes a given entity.
     *
     * @param entity Entidad que se quiere eliminar de la base de datos
     * @throws IllegalArgumentException
     *             in case the given entity is {@literal null}.
     */
    public void delete(T entity) throws ServiceException {
        getRepository().delete(entity);
    }

    /**
     * Deletes the given entities.
     *
     * @param entities Registros que se quieren eliminar de la base de datos
     * @throws IllegalArgumentException
     *             in case the given {@link Iterable} is {@literal null}.
     */
    public void delete(Iterable<? extends T> entities) throws ServiceException {
        getRepository().delete(entities);
    }

    /**
     * Deletes all entities managed by the repository.
     */
    public void deleteAll() throws ServiceException {
        getRepository().deleteAll();
    }

    /**
     * Retrieves an entity by its id.
     *
     * @param id
     *            must not be {@literal null}.
     * @return the entity with the given id or {@literal null} if none found
     * @throws IllegalArgumentException
     *             if {@code id} is {@literal null}
     */
    public T findOne(I id) throws ServiceException {
        return getRepository().findOne(id);
    }

    /**
     * Returns whether an entity with the given id exists.
     *
     * @param id
     *            must not be {@literal null}.
     * @return true if an entity with the given id exists, {@literal false} otherwise
     * @throws IllegalArgumentException
     *             if {@code id} is {@literal null}
     */
    public boolean exists(I id) throws ServiceException {
        return getRepository().exists(id);
    }

    /**
     * Saves a given entity. Use the returned instance for further operations as the save operation might have changed the entity instance completely.
     *
     * @param entity Entidad que se quiere guardar en base de datos
     * @return the saved entity
     */
    public <S extends T> S save(S entity) throws ServiceException {
        entity.setTimestamp(LocalDateTime.now());
        return getRepository().save(entity);
    }

    /**
     * Saves all given entities.
     *
     * @param entities Lista de entidades que se quieren guardar en base de datos
     * @return the saved entities
     * @throws IllegalArgumentException
     *             in case the given entity is {@literal null}.
     */
    public <S extends T> List<S> save(Iterable<S> entities) throws ServiceException {
        entities.forEach(entity -> entity.setTimestamp(LocalDateTime.now()));
        return getRepository().save(entities);

    }

    /**
     * Flushes all pending changes to the database.
     */
    public void flush() throws ServiceException {
        getRepository().flush();
    }

    /**
     * Saves an entity and flushes changes instantly.
     *
     * @param entity Entidad que se quiere guardar
     * @return the saved entity
     */
    public <S extends T> S saveAndFlush(S entity) throws ServiceException {
        entity.setTimestamp(LocalDateTime.now());
        return getRepository().saveAndFlush(entity);
    }

    /**
     * Deletes the given entities in a batch which means it will create a single {@link Query}. Assume that we will clear the {@link javax.persistence.EntityManager} after the
     * call.
     *
     * @param entities Entidades que se quieren eliminar de la base de datos
     */
    public void deleteInBatch(Iterable<T> entities) throws ServiceException {
        getRepository().deleteInBatch(entities);
    }

    /**
     * Deletes all entites in a batch call.
     */
    public void deleteAllInBatch() throws ServiceException {
        getRepository().deleteAllInBatch();
    }

    /**
     * Returns a reference to the entity with the given identifier.
     *
     * @param id
     *            must not be {@literal null}.
     * @return a reference to the entity with the given identifier.
     * @see EntityManager#getReference(Class, Object)
     */
    public T getOne(I id) throws ServiceException {
        return getRepository().getOne(id);
    }
}
