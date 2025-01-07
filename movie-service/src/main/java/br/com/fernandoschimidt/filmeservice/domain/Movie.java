package br.com.fernandoschimidt.filmeservice.domain;

public record Movie(Long id, String name, Long streamId, String description, Integer release, Integer duration) {
}
