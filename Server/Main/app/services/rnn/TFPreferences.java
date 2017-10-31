package services.rnn;


/**
 * Created by Lars Badde
 */
public class TFPreferences {
    public Integer NR_OF_EPOCHS;
    public Integer NR_OF_STEPS;
    public Integer NR_OF_LAYERS;
    public Integer NR_OF_NEURONS;
    public Integer NR_OF_OUTPUTS;
    public Integer NR_OF_INPUTS;
    public Integer BATCH_SIZE;
    public Boolean PREPROCESS_COLLAPSE_REPEATED;
    public  Boolean CTC_MERGE_REPEATED;
    public  Boolean APPLY_DROPOUT;
    public  Float KEEP_PROB;
    public  String ACTIVATION;
    public  Float LEARNING_RATE;
    public  String OPTIMIZER;
    public  Float MOMENTUM;
    public  Float EPSILON;
    public  Float DECAY_1;
    public  Float DECAY_2;
    public  Boolean USE_LOCKING;
    public  Boolean CENTERED;

    public TFPreferences() {
    }

    public TFPreferences(Integer NR_OF_EPOCHS, Integer NR_OF_STEPS, Integer NR_OF_LAYERS, Integer NR_OF_NEURONS, Integer NR_OF_OUTPUTS, Integer NR_OF_INPUTS, Integer BATCH_SIZE, Boolean PREPROCESS_COLLAPSE_REPEATED,
                       Boolean CTC_MERGE_REPEATED, Boolean APPLY_DROPOUT, Float KEEP_PROB, String ACTIVATION, Float LEARNING_RATE, String OPTIMIZER, Float MOMENTUM, Float EPSILON,Float DECAY_1, Float DECAY_2,
                       Boolean USE_LOCKING, Boolean CENTERED) {
        this.NR_OF_EPOCHS = NR_OF_EPOCHS;
        this.NR_OF_STEPS = NR_OF_STEPS;
        this.NR_OF_LAYERS = NR_OF_LAYERS;
        this.NR_OF_NEURONS = NR_OF_NEURONS;
        this.NR_OF_OUTPUTS = NR_OF_OUTPUTS;
        this.NR_OF_INPUTS = NR_OF_INPUTS;
        this.BATCH_SIZE = BATCH_SIZE;
        this.PREPROCESS_COLLAPSE_REPEATED = PREPROCESS_COLLAPSE_REPEATED;
        this.CTC_MERGE_REPEATED = CTC_MERGE_REPEATED;
        this.APPLY_DROPOUT = APPLY_DROPOUT;
        this.KEEP_PROB = KEEP_PROB;
        this.ACTIVATION = ACTIVATION;
        this.LEARNING_RATE = LEARNING_RATE;
        this.OPTIMIZER = OPTIMIZER;
        this.MOMENTUM = MOMENTUM;
        this.EPSILON = EPSILON;
        this.DECAY_1 = DECAY_1;
        this.DECAY_2 = DECAY_2;
        this.USE_LOCKING = USE_LOCKING;
        this.CENTERED = CENTERED;

    }
}