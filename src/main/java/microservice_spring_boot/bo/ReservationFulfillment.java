package microservice_spring_boot.bo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.util.StringUtils;

import com.google.gson.JsonElement;

public class ReservationFulfillment implements Serializable{

	/*private Long reservation_id;
	private String message;*/
	
	private static final long serialVersionUID = 1L;

	  private String speech;

	  private List<ResponseMessage> messages;

	  private String displayText;

	  private Map<String, JsonElement> data;

	  private String source;

	  private List<AIOutputContext> contextOut;

	  private AIEvent followupEvent;

	  /** Get voice response to the request */
	  public String getSpeech() {
	    return speech;
	  }

	  /** Set voice response to the request */
	  public void setSpeech(final String speech) {
	    this.speech = speech;
	  }

	  /** Get list of {@link ResponseMessage} objects */
	  public List<ResponseMessage> getMessages() {
	    return messages;
	  }

	  /** Set list of {@link ResponseMessage} objects */
	  public void setMessages(List<ResponseMessage> messages) {
	    this.messages = messages;
	  }
	  
	  /** Set sequence of {@link ResponseMessage} objects */
	  public void setMessages(ResponseMessage... messages) {
	    setMessages(Arrays.asList(messages));
	  }

	  /**
	   * @deprecated this method name is a typo, use <code>setMessages</code> method instead
	   */
	  @Deprecated
	  public void getMessages(List<ResponseMessage> messages) {
	    // TODO remove this method after major version change
	    setMessages(messages);
	  }

	  /** Get additional data required for performing the action on the client side. */
	  public Map<String, JsonElement> getData() {
	    return data;
	  }

	  /** Set additional data required for performing the action on the client side. */
	  public void setData(final Map<String, JsonElement> data) {
	    this.data = data;
	  }

	  /** Get text displayed on the user device screen. */
	  public String getDisplayText() {
	    return displayText;
	  }

	  /** Set text displayed on the user device screen. */
	  public void setDisplayText(final String displayText) {
	    this.displayText = displayText;
	  }

	  /** Get a data source */
	  public String getSource() {
	    return source;
	  }

	  /** Set a data source */
	  public void setSource(final String source) {
	    this.source = source;
	  }

	  /** Get list of context objects set after intent completion. */
	  public List<AIOutputContext> getContextOut() {
	    return contextOut;
	  }

	  /** Get context object by its name. */
	  public AIOutputContext getContext(final String name) {
	    if (StringUtils.isEmpty(name)) {
	      throw new IllegalArgumentException("name argument must be not empty");
	    }

	    if (contextOut == null) {
	      return null;
	    }

	    for (final AIOutputContext c : contextOut) {
	      if (name.equalsIgnoreCase(c.getName())) {
	        return c;
	      }
	    }

	    return null;
	  }

	  /** Set list of context objects set after intent completion. */
	  public void setContextOut(final List<AIOutputContext> contextOut) {
	    this.contextOut = contextOut;
	  }
	  
	  /** Set sequence of context objects set after intent completion. */
	  public void setContextOut(final AIOutputContext... contextOut) {
	    setContextOut(Arrays.asList(contextOut));
	  }

	  /** Get follow up event to be triggered*/
	  public AIEvent getFollowupEvent() {
	    return followupEvent;
	  }

	  /** Set follow up event to be triggered */
	  public void setFollowupEvent(AIEvent followupEvent) {
	    this.followupEvent = followupEvent;
	  }

	/*public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getReservation_id() {
		return reservation_id;
	}

	public void setReservation_id(Long reservation_id) {
		this.reservation_id = reservation_id;
	}*/
}
