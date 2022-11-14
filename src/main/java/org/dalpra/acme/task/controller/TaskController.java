package org.dalpra.acme.task.controller;

import java.util.List;

import org.dalpra.acme.task.entity.Task;

import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;

@Stateless
public class TaskController {

    @PersistenceContext
    private EntityManager em;

    public List<Task> loadAll() {
        return em.createNamedQuery(Task.FIND_ALL).getResultList();
    }

    public Task add(String title) {
        final Task newTask = new Task();
        newTask.setTitle(title);

        this.em.persist(newTask);
        this.em.flush();
        this.em.refresh(newTask);

        return newTask;
    }

    public Task delete(Long id) {
        try {
            Task ref = this.em.getReference(Task.class, id);
            this.em.remove(ref);
            return ref;
        } catch (EntityNotFoundException enf) {
            throw new EJBException(enf);
        }
    }

    public Task update(Long id, String title) {
        try {
            final Task ref = this.em.getReference(Task.class, id);
            ref.setTitle(title);
            return this.em.merge(ref);
        } catch (EntityNotFoundException enf) {
            throw new EJBException(enf);
        }
    }
}