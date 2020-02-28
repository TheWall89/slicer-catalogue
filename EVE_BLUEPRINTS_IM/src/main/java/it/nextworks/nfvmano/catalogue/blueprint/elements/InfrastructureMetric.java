/*
 * Copyright 2018 Nextworks s.r.l.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package it.nextworks.nfvmano.catalogue.blueprint.elements;


import javax.persistence.Embeddable;

import it.nextworks.nfvmano.libs.ifa.common.DescriptorInformationElement;
import it.nextworks.nfvmano.libs.ifa.common.exceptions.MalformattedElementException;

@Embeddable
//@DiscriminatorValue("INFRASTRUCTURE")
public class InfrastructureMetric implements DescriptorInformationElement {
	
	private InfrastructureMetricType iMetricType;
	private String metricId;
    private String name;
    private MetricCollectionType metricCollectionType;
    private String unit;
    private String interval;

	public InfrastructureMetric() {
		// JPA only
	}
	
	public InfrastructureMetric(String metricId, 
			String name,
			MetricCollectionType metricCollectionType, 
			String unit, 
			String interval,
			String topic,
			InfrastructureMetricType iMetricType) {
		this.metricId = metricId;
        this.name = name;
        this.metricCollectionType = metricCollectionType;
        this.unit = unit;
        this.interval = interval;
        this.iMetricType = iMetricType;
    }

	
	
	/**
	 * @return the metricId
	 */
	public String getMetricId() {
		return metricId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the metricCollectionType
	 */
	public MetricCollectionType getMetricCollectionType() {
		return metricCollectionType;
	}

	/**
	 * @return the unit
	 */
	public String getUnit() {
		return unit;
	}

	/**
	 * @return the interval
	 */
	public String getInterval() {
		return interval;
	}

	/**
	 * @return the iMetricType
	 */
	public InfrastructureMetricType getiMetricType() {
		return iMetricType;
	}
	
	@Override
    public void isValid() throws MalformattedElementException {

        if(metricId == null || metricId.equals(""))
            throw new MalformattedElementException("Metric without metricId");
        if(name == null || name.equals(""))
            throw new MalformattedElementException("Metric without name");
        if(unit == null || unit.equals(""))
            throw new MalformattedElementException("Metric without unit");
        if(metricCollectionType == null)
            throw new MalformattedElementException("Metric without MetricCollectionType");

    }

}
