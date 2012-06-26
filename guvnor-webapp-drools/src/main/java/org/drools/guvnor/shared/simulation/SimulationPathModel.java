/*
 * Copyright 2012 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.drools.guvnor.shared.simulation;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.drools.guvnor.shared.api.PortableObject;

import java.util.TreeMap;

/**
 * This is a DTO.
 */
@XStreamAlias("SimulationPathModel")
public class SimulationPathModel implements PortableObject {

    public static SimulationPathModel createNew() {
        SimulationPathModel path = new SimulationPathModel();
        path.addStep(SimulationStepModel.createNew());
        path.addStep(SimulationStepModel.createNew()); // TODO remove me
        path.addStep(SimulationStepModel.createNew()); // TODO remove me
        return path;
    }

    private String name;
    // TODO the field type should be NavigableMap - http://code.google.com/p/google-web-toolkit/issues/detail?id=4236
    private TreeMap<Long, SimulationStepModel> steps = new TreeMap<Long, SimulationStepModel>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // TODO the return type should be NavigableMap - http://code.google.com/p/google-web-toolkit/issues/detail?id=4236
    public TreeMap<Long, SimulationStepModel> getSteps() {
        return steps;
    }

    public void addStep(SimulationStepModel step) {
        if (step.getDistanceMillis() == null) {
            generateStepDistanceMillis(step);
        }
        if (steps.containsKey(step.getDistanceMillis())) {
            throw new IllegalArgumentException("The simulation step's distanceMillis ("
                    + step.getDistanceMillis() + ") is not unique.");
        }
        steps.put(step.getDistanceMillis(), step);
    }

    private void generateStepDistanceMillis(SimulationStepModel step) {
        Long stepDistanceMillis;
        if (steps.isEmpty()) {
            stepDistanceMillis = 0L;
        } else {
            stepDistanceMillis = steps.lastKey() + 1000L;
        }
        step.setDistanceMillis(stepDistanceMillis);
    }

}
