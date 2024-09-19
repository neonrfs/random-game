package net.radley;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Saves {
    
    private ObjectMapper objMapper;
    private JsonNode node;
    protected static int[] scores = new int[3];

    public Saves() {
        File file = new File(getClass().getResource("saves.json").getPath().replace("%20", " "));
        try {
            objMapper = new ObjectMapper();
            node = objMapper.readTree(file);
            scores[0] = node.get("easy").asInt();
            scores[1] = node.get("normal").asInt();
            scores[2] = node.get("hard").asInt();
            for (int i = 0; i < scores.length; i++) {
                // System.out.println(scores[i]);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void reset() {
        File file = new File(getClass().getResource("saves.json").getPath().replace("%20", " "));
        try {
            scores[0] = 1000;
            scores[1] = 1000;
            scores[2] = 1000;
            node = ((ObjectNode)node).removeAll();
            node = ((ObjectNode)node).put("easy", 1000);
            node = ((ObjectNode)node).put("normal", 1000);
            node = ((ObjectNode)node).put("hard", 1000);
            objMapper.writeValue(file, node);
            // System.out.println("Saved successfully!");
        } catch (StreamWriteException e) {
            System.out.println(e);
        } catch (DatabindException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void save() {
        File file = new File(getClass().getResource("saves.json").getPath().replace("%20", " "));
        try {
            node = ((ObjectNode)node).removeAll();
            node = ((ObjectNode)node).put("easy", scores[0]);
            node = ((ObjectNode)node).put("normal", scores[1]);
            node = ((ObjectNode)node).put("hard", scores[2]);
            objMapper.writeValue(file, node);
            // System.out.println("Saved successfully!");
        } catch (StreamWriteException e) {
            System.out.println(e);
        } catch (DatabindException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
