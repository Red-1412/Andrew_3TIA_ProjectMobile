---
name: Academic Peer Note Sharing
colors:
  surface: '#faf8ff'
  surface-dim: '#d2d9f4'
  surface-bright: '#faf8ff'
  surface-container-lowest: '#ffffff'
  surface-container-low: '#f2f3ff'
  surface-container: '#eaedff'
  surface-container-high: '#e2e7ff'
  surface-container-highest: '#dae2fd'
  on-surface: '#131b2e'
  on-surface-variant: '#434655'
  inverse-surface: '#283044'
  inverse-on-surface: '#eef0ff'
  outline: '#737686'
  outline-variant: '#c3c6d7'
  surface-tint: '#0053db'
  primary: '#004ac6'
  on-primary: '#ffffff'
  primary-container: '#2563eb'
  on-primary-container: '#eeefff'
  inverse-primary: '#b4c5ff'
  secondary: '#1d4ed8'
  on-secondary: '#ffffff'
  secondary-container: '#4069f2'
  on-secondary-container: '#fffbff'
  tertiary: '#485767'
  on-tertiary: '#ffffff'
  tertiary-container: '#606f80'
  on-tertiary-container: '#e9f2ff'
  error: '#ba1a1a'
  on-error: '#ffffff'
  error-container: '#ffdad6'
  on-error-container: '#93000a'
  primary-fixed: '#dbe1ff'
  primary-fixed-dim: '#b4c5ff'
  on-primary-fixed: '#00174b'
  on-primary-fixed-variant: '#003ea8'
  secondary-fixed: '#dce1ff'
  secondary-fixed-dim: '#b7c4ff'
  on-secondary-fixed: '#001551'
  on-secondary-fixed-variant: '#0039b5'
  tertiary-fixed: '#d5e4f8'
  tertiary-fixed-dim: '#b9c8db'
  on-tertiary-fixed: '#0e1d2b'
  on-tertiary-fixed-variant: '#3a4858'
  background: '#faf8ff'
  on-background: '#131b2e'
  surface-variant: '#dae2fd'
typography:
  display-lg:
    fontFamily: Plus Jakarta Sans
    fontSize: 32px
    fontWeight: '700'
    lineHeight: 40px
    letterSpacing: -0.02em
  headline-lg:
    fontFamily: Plus Jakarta Sans
    fontSize: 24px
    fontWeight: '700'
    lineHeight: 32px
    letterSpacing: -0.015em
  headline-md:
    fontFamily: Plus Jakarta Sans
    fontSize: 20px
    fontWeight: '600'
    lineHeight: 28px
    letterSpacing: -0.01em
  title-md:
    fontFamily: Plus Jakarta Sans
    fontSize: 18px
    fontWeight: '600'
    lineHeight: 26px
  body-lg:
    fontFamily: Plus Jakarta Sans
    fontSize: 16px
    fontWeight: '400'
    lineHeight: 24px
  body-md:
    fontFamily: Plus Jakarta Sans
    fontSize: 14px
    fontWeight: '400'
    lineHeight: 20px
  body-sm:
    fontFamily: Plus Jakarta Sans
    fontSize: 12px
    fontWeight: '400'
    lineHeight: 16px
  label-lg:
    fontFamily: Plus Jakarta Sans
    fontSize: 14px
    fontWeight: '600'
    lineHeight: 20px
  label-md:
    fontFamily: Plus Jakarta Sans
    fontSize: 12px
    fontWeight: '600'
    lineHeight: 16px
    letterSpacing: 0.02em
  label-sm:
    fontFamily: Plus Jakarta Sans
    fontSize: 11px
    fontWeight: '500'
    lineHeight: 14px
rounded:
  sm: 0.25rem
  DEFAULT: 0.5rem
  md: 0.75rem
  lg: 1rem
  xl: 1.5rem
  full: 9999px
spacing:
  gutter: 1rem
  margin: 1.25rem
  space-xs: 0.25rem
  space-sm: 0.5rem
  space-md: 0.75rem
  space-lg: 1rem
  space-xl: 1.5rem
---

## Brand & Style
The design system establishes a focused, optimistic, and collegiate environment tailored for university students collaborating on study materials, lecture summaries, and exam resources. The aesthetic balances crisp academic efficiency with a friendly, welcoming peer-to-peer tone. 

Visual principles prioritize clarity, high legibility under varying study conditions, and distraction-free content consumption. Utilizing a modern minimalist foundation augmented with light blue tinted layered surfaces, the interface creates an inviting, organized desk space metaphor. Surfaces feel airy and tactile without visual clutter, encouraging active contribution, rapid search, and structured reading.

## Colors
The palette leverages a crisp blue spectrum alongside purposeful neutrals to foster an orderly, calm academic setting:

- **Primary Canvas & Layering:** Core background renders in `#FFFFFF` with alternating surface panels and structural sections utilizing `#F8FAFC`. Highlighting containers, active filters, and informational cards leverage `#EFF6FF` to delineate student-generated summaries.
- **Brand & Interaction:** Key interactive touchpoints, primary actions, and download triggers use Primary Blue `#2563EB`, transitioning to `#1D4ED8` during pressed or active states. Subtle badges and active tab chips apply `#DBEAFE` as a fill tint with `#1D4ED8` typography.
- **Typography & Structure:** Primary body text and headers use `#0F172A` for clear contrast and strain-free reading. Contextual metadata, timestamps, author bios, and file formats use `#64748B`. Dividers and structural separators maintain light definition with `#E2E8F0`.
- **System Feedback:** Successful uploads and peer endorsements resolve in `#22C55E`; document review ratings and bookmarks invoke `#F59E0B`; critical validation warnings and deletion dialogs resolve in `#EF4444`.

## Typography
Plus Jakarta Sans is utilized across all typographical scales to deliver high legibility, approachable geometry, and structured text flow. 

Document titles and major view headers lean on semi-bold and bold weights to ground the eye quickly on busy feeds. Reading viewports, document overviews, and file previews favor comfortable vertical line heights (`lineHeight` ≥ 1.5x) to alleviate fatigue during extended study sessions. Metadata labels, university course codes, and page counters rely on concise medium weights with subtle tracking to maximize scan efficiency.

## Layout & Spacing
The layout adheres strictly to a mobile-first fluid model governed by a standard 20px (`1.25rem`) horizontal outer screen margin to guarantee comfortable edge clearance on touch devices. Internal grids rely on a 4-column framework for mobile viewport compositions, scaling fluidly across wider formats.

Vertical pacing follows an 8px base rhythm. Content modules (course clusters, recent lecture notes, shared bundles) are separated by `space-xl` (24px) gaps to ensure distinct cognitive separation. Tight metadata pairings, such as download counters paired with peer rating stars, use `space-xs` (4px) or `space-sm` (8px).

## Elevation & Depth
Depth is created through soft ambient shadows and low-contrast borders rather than harsh drop-shadows or stark outlines:

- **Level 0 (Flat):** Used for default full-screen canvases (`#FFFFFF`) and content wells (`#F8FAFC`).
- **Level 1 (Card & Module Resting):** Applied to note cards and interactive list items. Combines a structural hairline border (`1px solid #E2E8F0`) with a diffuse, tinted ambient drop-shadow: `0 4px 12px -2px rgba(15, 23, 42, 0.04), 0 2px 6px -1px rgba(37, 99, 235, 0.03)`.
- **Level 2 (Active & Floating Elements):** Applied to floating action buttons (upload new document), fixed search inputs, and popovers: `0 10px 24px -4px rgba(15, 23, 42, 0.08), 0 4px 8px -2px rgba(37, 99, 235, 0.06)`.
- **Level 3 (Modals & Bottom Sheets):** Modal overlays and document preview trays: `0 20px 32px -8px rgba(15, 23, 42, 0.14)`.

## Shapes
The shape system prioritizes soft, friendly geometry to soften academic intensity while remaining professional:

- **Cards and Major Containers:** Built uniformly with a 16px corner radius (`rounded-lg`), creating friendly, tactile, and distinct modules for document entries.
- **Buttons and Action Targets:** Standardized with a 12px to 14px corner radius to ensure cohesive visual alignment alongside nested input fields.
- **Tags, Filter Chips, and Badges:** Finished with a full pill radius (`9999px`) to immediately signal interactive or categorized touch affordance.

## Components

### Buttons
- **Primary Action:** Solid `#2563EB` fill, white `#FFFFFF` text, 12px-14px border radius, 48px height for thumb-friendly reach. Transitions to `#1D4ED8` on tap.
- **Secondary Action:** `#EFF6FF` background with `#2563EB` text, zero border, 12px-14px border radius.
- **Outlined / Tertiary:** Transparent background, `1px solid #E2E8F0`, `#0F172A` text.

### Cards (Study Notes & Materials)
- Formed with a 16px radius, `#FFFFFF` background, `1px solid #E2E8F0`, and Level 1 elevation.
- Internal padding is set to 16px (`space-lg`). Includes a header tier displaying subject pill tag, semester code, and star rating (`#F59E0B`), followed by a 2-line title preview and an author avatar footer.

### Search & Text Inputs
- 48px minimum touch height with a 12px radius. Background `#F8FAFC`, border `1px solid #E2E8F0`, and placeholder text in `#64748B`.
- Transitions to `#FFFFFF` background with a focused ring of `1.5px solid #2563EB` and light glow `rgba(37, 99, 235, 0.12)`.

### Chips & Filter Pills
- Heights fixed at 32px for filters and 24px for static metadata tags. 
- Inactive state: `#F8FAFC` background, `1px solid #E2E8F0`, `#64748B` label.
- Active state: `#EFF6FF` background, `1px solid #DBEAFE`, `#2563EB` label with medium font weight.

### Lists & Activity Feeds
- Clean divider-separated or decoupled card-based rows.
- Each row hosts a 40px rounded document icon container (tinted `#EFF6FF` with `#2563EB` glyph), main title, file format badge (.PDF, .DOCX), and download counter.

### Checkboxes & Selection Controls
- Checkbox elements use a 6px rounded border box with `#E2E8F0` border in default state, filling with `#2563EB` and a white check icon upon selection.
- Radios feature standard circular form factors with `#2563EB` concentric active rings.

### PDF & Document Viewer Bar
- Persistent bottom floating utility container styled with a 16px radius, Level 2 elevation, `#FFFFFF` fill, and subtle `#E2E8F0` border. Integrates page jump shortcuts, bookmark toggles, and peer discussion shortcuts.