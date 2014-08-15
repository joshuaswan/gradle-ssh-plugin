package org.hidetake.gradle.ssh.internal

import org.gradle.util.ConfigureUtil
import org.hidetake.groovy.ssh.api.CompositeSettings
import org.hidetake.gradle.ssh.plugin.SshTaskHandler

/**
 * A service for SSH tasks.
 *
 * @author hidetake.org
 */
@Singleton(lazy = true)
class SshTaskService {
    /**
     * Create a task delegate object.
     *
     * @return a task delegate
     */
    SshTaskHandler createDelegate() {
        new DefaultSshTaskHandler()
    }

    /**
     * Execute a closure.
     *
     * @param globalSettings
     * @param closure closure for {@link org.hidetake.groovy.ssh.api.session.SessionHandler}
     * @return returned value of the last session
     */
    Object execute(CompositeSettings globalSettings, Closure closure) {
        def handler = createDelegate()
        ConfigureUtil.configure(closure, handler)
        handler.execute(globalSettings)
    }
}
