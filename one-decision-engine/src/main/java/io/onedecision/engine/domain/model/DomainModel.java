/*******************************************************************************
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package io.onedecision.engine.domain.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "OL_DOMAIN_MODEL")
@Component
public class DomainModel {
    protected static final Logger LOGGER = LoggerFactory.getLogger(DomainModel.class);

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty
    private Long id;

    @NotNull
    @JsonProperty
    protected String name;

    @JsonProperty
    protected String description;

    @JsonProperty
    protected String imageUrl;

    @Column(name = "REV")
    @JsonProperty
    private Long revision;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    @JsonProperty
    private Date firstCreated;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    @JsonProperty
    private Date lastUpdated;

    @NotNull
    @JsonProperty
    @Column(nullable = false)
    private String tenantId;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "MODEL_ID")
    private List<DomainEntity> entities;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

    public Long getRevision() {
        return revision;
    }

    public void setRevision(Long revision) {
        this.revision = revision;
    }

    public Date getFirstCreated() {
		return firstCreated;
	}

	public void setFirstCreated(Date firstCreated) {
		this.firstCreated = firstCreated;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public List<DomainEntity> getEntities() {
        if (entities == null) {
            entities = new ArrayList<DomainEntity>();
        }
		return entities;
	}

	public void setEntities(List<DomainEntity> entities) {
		this.entities = entities;
	}

    public DomainModel withId(Long id) {
        setId(id);
        return this;
    }

    public DomainModel withName(String name) {
        setName(name);
        return this;
    }

    public DomainModel withDescription(String description) {
        setDescription(description);
        return this;
    }

    public DomainModel withImageUrl(String imageUrl) {
        setImageUrl(imageUrl);
        return this;
    }

    public DomainModel withRevision(Long revision) {
        setRevision(revision);
        return this;
    }

    public DomainModel withFirstCreated(Date created) {
        setFirstCreated(created);
        return this;
    }

    public DomainModel withLastUpdated(Date lastUpdated) {
        setLastUpdated(lastUpdated);
        return this;
    }

    public DomainModel withTenantId(String tenantId) {
        setTenantId(tenantId);
        return this;
    }

    public DomainModel withEntities(List<DomainEntity> entities) {
        getEntities().addAll(entities);
        return this;
    }

    public DomainModel withEntity(DomainEntity entity) {
        getEntities().add(entity);
        return this;
    }
}
