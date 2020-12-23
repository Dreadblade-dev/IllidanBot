package com.dreadblade.illidanbot.command;

import com.dreadblade.illidanbot.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractCommand implements Command {
    @Autowired
    protected MessageService messageService;
}
