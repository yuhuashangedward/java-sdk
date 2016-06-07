package com.ibm.watson.developer_cloud.conversation.v1_experimental.model;

import java.util.Map;

import com.ibm.watson.developer_cloud.conversation.v1_experimental.ConversationService;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * The response payload from the Conversation service's message API call
 * {@link ConversationService#message(String, MessageRequest)}
 * 
 * @see <a href="http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/conversation.html">
 *      http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/conversation.html</a>
 */
public class MessageResponse extends GenericModel {
  /**
   * An class used to describe the entity payload object
   */
  public static class Entity {
    private String entity;
    private int[] location;
    private String value;

    /**
     * Returns the name of the entity. e.g. "I'd like to get a pepperoni pizza", entity in this case
     * would likely be "topping" (depending on how the system has been trained). The
     * {@link #getValue()} of the input would be "pepperoni".
     * 
     * @return the name of an entity
     */
    public String getEntity() {
      return entity;
    }

    /**
     * Returns the location of the entity within the input string, the array will have two values: a
     * start index and end index.
     * 
     * @return an array of locations (start and end)
     */
    public int[] getLocation() {
      return location;
    }

    /**
     * Returns the detected value of the entity.
     * 
     * @return a string representing the entity value
     */
    public String getValue() {
      return value;
    }

    /**
     * Sets the entity detected by the system for the given input.
     * 
     * @param entity
     */
    public void setEntity(String entity) {
      this.entity = entity;
    }

    /**
     * Sets the location of the entity detected by the system (i.e. starting index and end index).
     * 
     * @param location an array of <code>ints</code> representing a start and end index
     */
    public void setLocation(int[] location) {
      this.location = location;
    }

    /**
     * Sets the value of the entity as detected by the system.
     * 
     * @param value
     */
    public void setValue(String value) {
      this.value = value;
    }
  }

  /**
   * A class representing an Intent as detected by the service. The intent is the 'intent' of the
   * user utterance, e.g. "pay_bill", "check_balance" etc.. The intent is accompanied by a
   * confidence score ranging between 0.0 and 1.0, with 1.0 being the most confident.
   */
  public static class Intent {
    private float confidence;
    private String intent;

    /**
     * Returns the confidence associated with the intent. When the service parses/analyzes the user
     * input it tries to determine the 'intent' of what the user said. The service will be trained
     * to expect n different intents and the service tries to match the input with one of the
     * intents. The confidence is the value assigned by the system to the returned intent. High
     * confidence scores (close to 1.0) imply that the system is very confident that the user meant
     * the returned intent. Low confidence scores indicate that the system is not confident in its
     * response.
     * 
     * @return a float representing system confidence
     */
    public float getConfidence() {
      return confidence;
    }

    /**
     * Returns the name of the intent that the system detected in the user input.
     * 
     * @return a string representing an intent name
     */
    public String getIntent() {
      return intent;
    }

    /**
     * Sets the system confidence in the intent
     * 
     * @param confidence a float between 0 and 1
     */
    public void setConfidence(float confidence) {
      this.confidence = confidence;
    }

    /**
     * Sets the name of the intent the system understood the user to have 'said'.
     * 
     * @param intent a string representing one of the trained intents
     */
    public void setIntent(String intent) {
      this.intent = intent;
    }
  }

  private Map<String, Object> context;
  private Entity[] entities;
  private Intent[] intents;
  private Map<String, Object> output;

  /**
   * Create a new instance of the message API response payload. The message API will always return a
   * list of intents, entities, an output and context.
   * 
   * <pre>
   * {
   *   intents:[{intent:"pay_bill", confidence: 0.86}, {intent: ......}],
   *   entities: [{entity:"phone", value:"telephone", location:[21, 30]],
   *   context:{some_var:"some val", address:{street: "22 Queen St", city: "Boston"}},
   *   output:{text: "I can help you pay your phone bill"}
   * }
   * </pre>
   */
  public MessageResponse() {}

  /**
   * Returns the context as returned by the service. At each step in the chat flow the conversation
   * designer has the ability to add information to the chat context. The context is a map of key
   * value pairs, with the values being any valid JSON objects/primatives.
   * 
   * @return a map representing context/state
   */
  public Map<String, Object> getContext() {
    return context;
  }

  /**
   * Returns the list of entities as detected by the service.
   * 
   * @return an array of {@link Entity} objects
   */
  public Entity[] getEntities() {
    return entities;
  }

  /**
   * Returns the list of intents as detected by the service.
   * 
   * @return an array of {@link Intent} objects.
   */
  public Intent[] getIntents() {
    return intents;
  }

  /**
   * Returns the output as returned by the service, may be null.
   * 
   * @return a map of objects representing the response from the Dialog portion of the service.
   */
  public Map<String, Object> getOutput() {
    return output;
  }

  /**
   * Sets the context as determined by the service.
   * 
   * @param context a map of key value pairs
   */
  public void setContext(Map<String, Object> context) {
    this.context = context;
  }

  /**
   * Sets a list of entities as detected by the service.
   * 
   * @param entities an array of entities
   */
  public void setEntities(Entity[] entities) {
    this.entities = entities;
  }

  /**
   * Sets a list of intents as detected by the service.
   * 
   * @param intents an array of intents
   */
  public void setIntents(Intent[] intents) {
    this.intents = intents;
  }

  /**
   * Sets the output as returned by the service
   * 
   * @param output a map of outputs as defined by the conversation designer
   */
  public void setOutput(Map<String, Object> output) {
    this.output = output;
  }

  /**
   * A convenience method for getting the text property from the output object. This is equivalent
   * to calling:
   * 
   * <pre>
   * String text = null; Map<String, Object> output = response.getOutput(); if(output != null){ text
   * = output.get("text"); }
   * 
   * @return the text which is to be displayed/returned to the end user
   */
  public String getText() {
    if (this.output != null && this.output.containsKey("text")) {
      return (String) this.output.get("text");
    }
    return null;
  }
}