---
name: Luminous Utility
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
  on-surface-variant: '#4a4455'
  inverse-surface: '#283044'
  inverse-on-surface: '#eef0ff'
  outline: '#7b7487'
  outline-variant: '#ccc3d8'
  surface-tint: '#732ee4'
  primary: '#630ed4'
  on-primary: '#ffffff'
  primary-container: '#7c3aed'
  on-primary-container: '#ede0ff'
  inverse-primary: '#d2bbff'
  secondary: '#5d5d67'
  on-secondary: '#ffffff'
  secondary-container: '#e3e1ed'
  on-secondary-container: '#64636d'
  tertiary: '#7d3d00'
  on-tertiary: '#ffffff'
  tertiary-container: '#a15100'
  on-tertiary-container: '#ffe0cd'
  error: '#ba1a1a'
  on-error: '#ffffff'
  error-container: '#ffdad6'
  on-error-container: '#93000a'
  primary-fixed: '#eaddff'
  primary-fixed-dim: '#d2bbff'
  on-primary-fixed: '#25005a'
  on-primary-fixed-variant: '#5a00c6'
  secondary-fixed: '#e3e1ed'
  secondary-fixed-dim: '#c7c5d1'
  on-secondary-fixed: '#1a1b23'
  on-secondary-fixed-variant: '#46464f'
  tertiary-fixed: '#ffdcc6'
  tertiary-fixed-dim: '#ffb784'
  on-tertiary-fixed: '#301400'
  on-tertiary-fixed-variant: '#713700'
  background: '#faf8ff'
  on-background: '#131b2e'
  surface-variant: '#dae2fd'
typography:
  headline-lg:
    fontFamily: Manrope
    fontSize: 32px
    fontWeight: '700'
    lineHeight: 40px
    letterSpacing: -0.02em
  headline-md:
    fontFamily: Manrope
    fontSize: 24px
    fontWeight: '600'
    lineHeight: 32px
    letterSpacing: -0.01em
  body-lg:
    fontFamily: Manrope
    fontSize: 18px
    fontWeight: '400'
    lineHeight: 28px
  body-md:
    fontFamily: Manrope
    fontSize: 16px
    fontWeight: '400'
    lineHeight: 24px
  label-md:
    fontFamily: Manrope
    fontSize: 14px
    fontWeight: '600'
    lineHeight: 20px
    letterSpacing: 0.05em
  label-sm:
    fontFamily: Manrope
    fontSize: 12px
    fontWeight: '500'
    lineHeight: 16px
rounded:
  sm: 0.25rem
  DEFAULT: 0.5rem
  md: 0.75rem
  lg: 1rem
  xl: 1.5rem
  full: 9999px
spacing:
  base: 4px
  xs: 4px
  sm: 8px
  md: 16px
  lg: 24px
  xl: 32px
  gutter: 16px
  margin: 20px
---

## Brand & Style

This design system is built on the principles of **Modern Minimalism**, emphasizing speed of utility and clarity of intent. The target audience includes tech-savvy individuals and professionals who require a frictionless scanning experience. The personality is energetic yet disciplined—using a high-energy primary color against a stark, breathable white canvas.

The emotional response should be one of "effortless efficiency." By removing unnecessary visual noise and focusing on high-quality typography and intentional whitespace, the design system ensures that the scanning interface remains the hero, while the supporting UI feels premium and lightweight.

## Colors

The palette is anchored by a **Vibrant Purple** (#7C3AED), which serves as the primary action color for buttons, active states, and focal points like the scanner viewfinder. This is contrasted against a dominant white background to maintain a sense of cleanliness and "air."

A secondary, very pale lavender is used for subtle backgrounds and surface-level distinctions, ensuring that the interface doesn't feel overly clinical. The neutral palette utilizes a deep slate for typography to ensure high legibility without the harshness of pure black. Functional colors (success, error) should follow standard conventions but be softened to match the vibrant primary hue.

## Typography

This design system utilizes **Manrope** for all type levels. Manrope’s modern, geometric construction and high legibility make it ideal for a utility-focused application.

Headlines feature tighter letter spacing and heavier weights to create a strong visual anchor on the page. Body text is optimized for readability with generous line heights. Labels use a slightly increased letter spacing and semi-bold weights to remain distinct even at smaller scales, ensuring that technical data from scanned codes is easily digestible.

## Layout & Spacing

The design system employs a **fluid grid** model tailored for mobile devices, using a base-4 spacing scale. A standard 12-column grid is used for tablet layouts, while mobile views rely on a single-column stack with 20px outer margins.

The spacing rhythm is intentionally spacious. Elements are grouped using a "proximity for purpose" philosophy—buttons and related controls are separated by 16px (md), while distinct sections are separated by 32px (xl) to maintain the minimal aesthetic. The scanner viewfinder should always be centered with a minimum safe-area margin of 40px from any overlapping UI elements.

## Elevation & Depth

Hierarchy is established through **Ambient Shadows** and tonal layering. Instead of heavy borders, the design system uses extremely diffused, low-opacity shadows (Blur: 20px-40px, Opacity: 4-8%) with a slight purple tint (#7C3AED) to lift elements off the white background.

Interactive elements like cards and primary buttons use a slightly higher elevation to suggest "pressability." During the scanning state, the background may use a semi-transparent dark overlay to focus the user's attention on the viewfinder, while results are presented on "Sheet" components that slide up from the bottom with a soft-shadow backdrop.

## Shapes

The shape language is defined by **Rounded** corners, creating a friendly and approachable feel that balances the technical nature of QR codes.

- Standard components (buttons, input fields) use a 0.5rem (8px) radius.
- Large containers (cards, bottom sheets) use a 1rem (16px) radius.
- The scanner viewfinder itself uses a unique 1.5rem (24px) corner radius for its bracket frame to make it feel like a modern lens.

Avoid sharp 90-degree angles across the interface to maintain the "soft" aesthetic of this design system.

## Components

### Buttons
Primary buttons are solid Vibrant Purple with white text, featuring a subtle shadow. Secondary buttons use a light lavender background with purple text. All buttons should have a minimum height of 56px to ensure a large touch target for mobile users.

### Cards
Cards are white with a 1px soft gray border (#F1F5F9) or a very soft shadow. They should be used to display scan history and categorized results (links, text, contact cards).

### Viewfinder
The QR viewfinder is the signature component. It consists of four corner brackets in Vibrant Purple, using a 3px stroke width. It may include a subtle "pulse" animation to indicate active scanning.

### Bottom Sheets
Scan results are presented in bottom sheets. These use a 1rem top-corner radius and a grab-bar at the top. They should allow for quick actions such as "Copy," "Open in Browser," or "Share."

### Input Fields
Used for creating QR codes. They feature a 0.5rem radius and a 1px border that turns Vibrant Purple upon focus. Use clear, floating labels to keep the interface minimal.

### Chips
Used for categorizing scan history (e.g., "URL," "WiFi," "Contact"). Chips should be pill-shaped with a light lavender background and small icons.