package se.project.business_logic.utilities.interfaces;

import se.project.storage.models.Maintainer;

/**
 * Provides utility method to notify task assignment to Maintainers.
 * 
 */
public interface MailSenderInterface
{
     /**
     * 
     * Send an email using GA2 Protocol.
     * @param maintainer is the recipient.
     * @throws Exception
     */
    public void notifyMaintainerActivity(Maintainer maintainer) throws Exception;
    
}
