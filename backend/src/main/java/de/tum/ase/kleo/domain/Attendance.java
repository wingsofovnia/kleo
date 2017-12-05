package de.tum.ase.kleo.domain;

import de.tum.ase.kleo.domain.id.PassId;
import de.tum.ase.kleo.domain.id.UserId;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.OffsetDateTime;

import static org.apache.commons.lang3.Validate.notNull;

@Embeddable @Access(AccessType.FIELD)
@Getter @Accessors(fluent = true) @ToString @EqualsAndHashCode
@NoArgsConstructor(force = true, access = AccessLevel.PACKAGE)
public class Attendance {

    @Column(nullable = false)
    private final PassId passId;

    @Column(nullable = false)
    private final UserId userId;

    @Column(name = "attended_at", nullable = false)
    private final OffsetDateTime attendedAt = OffsetDateTime.now();

    public Attendance(PassId passId, UserId userId) {
        this.passId = notNull(passId);
        this.userId = notNull(userId);
    }
}
