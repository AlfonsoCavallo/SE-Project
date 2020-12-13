package se.project.business_logic.utilities.interfaces;

import se.project.storage.models.Maintainer;


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
