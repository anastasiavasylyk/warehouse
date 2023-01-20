package org.example.mapper;

public interface DtoRequestMapper<D, C> {
    C fromDto(D dto);
}
