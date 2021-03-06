
package org.omg.dss;

import javax.xml.ws.WebFault;

import org.omg.dss.exception.EvaluationException;


/**
 * This class was generated by Apache CXF 2.2.9
 * Thu Jul 28 08:04:45 MDT 2011
 * Generated source version: 2.2.9
 * 
 */

@WebFault(name = "EvaluationException", targetNamespace = "http://www.omg.org/spec/CDSS/201105/dss")
public class EvaluationExceptionFault extends Exception {
    public static final long serialVersionUID = 20110728080445L;
    
    private EvaluationException evaluationException;

    public EvaluationExceptionFault() {
        super();
    }
    
    public EvaluationExceptionFault(String message) {
        super(message);
    }
    
    public EvaluationExceptionFault(String message, Throwable cause) {
        super(message, cause);
    }

    public EvaluationExceptionFault(String message, EvaluationException evaluationException) {
        super(message);
        this.evaluationException = evaluationException;
    }

    public EvaluationExceptionFault(String message, EvaluationException evaluationException, Throwable cause) {
        super(message, cause);
        this.evaluationException = evaluationException;
    }

    public EvaluationException getFaultInfo() {
        return this.evaluationException;
    }
}
