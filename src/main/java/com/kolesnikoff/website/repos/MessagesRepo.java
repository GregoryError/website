package com.kolesnikoff.website.repos;

import com.kolesnikoff.website.models.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessagesRepo extends CrudRepository<Message, Long> {
}
