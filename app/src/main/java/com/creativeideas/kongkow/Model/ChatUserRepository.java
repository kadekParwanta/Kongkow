package com.creativeideas.kongkow.Model;

import com.strongloop.android.loopback.UserRepository;

/**
 * Created by Kadek_P on 4/13/2016.
 */
public class ChatUserRepository extends UserRepository<ChatUser> {

    public interface LoginCallback extends UserRepository.LoginCallback<ChatUser> {

    }

    public ChatUserRepository() {
        super("chatuser", null, ChatUser.class);
    }
}
