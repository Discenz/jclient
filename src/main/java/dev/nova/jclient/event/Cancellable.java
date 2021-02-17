package dev.nova.jclient.event;

public class Cancellable extends Event {
    private boolean cancelled;

    public Cancellable() {
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public void cancel () {
        this.cancelled = true;
    }
}
