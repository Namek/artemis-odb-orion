package se.feomedia.orion.system;

import com.artemis.Aspect;
import com.esotericsoftware.kryo.Kryo;

import com.badlogic.gdx.math.OrionKryoSerialization;
import se.feomedia.orion.Operation;
import se.feomedia.orion.component.Operative;

public class SerializableOperationSystem extends OperationSystem {

	public Kryo kryo;

	public SerializableOperationSystem(Aspect.Builder base) {
		super(base.all(Operative.class));
	}

	@Override
	protected void initialize() {
		super.initialize();
		kryo = new Kryo();
		OrionKryoSerialization.configure(kryo);
	}

	public <T extends Operation> T copy(T operation) {
		return kryo.copy(operation);
	}
}
