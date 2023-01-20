package org.example.mapper;

public interface DtoResponseMapper<D, C> {
    D toDto(C object);
}
